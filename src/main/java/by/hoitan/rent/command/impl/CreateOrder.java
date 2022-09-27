package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.Order;
import by.hoitan.rent.bean.OrderStatus;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.dao.impl.SQLOrderDAO;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.OrderServiceImpl;
import by.hoitan.rent.util.JspHelper;
import by.hoitan.rent.util.LocalDateFormatter;
import by.hoitan.rent.validator.OrderChecker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class CreateOrder implements Command {

    private static final Logger LOGGER = LogManager.getLogger(CreateOrder.class);

//    private final SQLOrderDAO orderDAO = SQLOrderDAO.getInstance();

    private final OrderServiceImpl orderService = OrderServiceImpl.getInstance();


    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        LOGGER.info("method execute()");

        var rentDate = LocalDateFormatter.format(request.getParameter("rent_date"));
        var returnDate = LocalDateFormatter.format(request.getParameter("return_date"));
        long days = returnDate.toEpochDay()-rentDate.toEpochDay();

        var order = Order.builder().price(BigDecimal.valueOf(Long.valueOf(request.getParameter("price"))*days))
                .rentDateTime(rentDate)
                .returnDateTime(returnDate)
                .carId(Integer.parseInt(request.getParameter("car_id"!=null?"car_id":"car")))
                .userId(Integer.parseInt(request.getParameter("user_id")))
                .orderStatus(OrderStatus.findOrderStatus(2))
                .build();
        var checkOrder = OrderChecker.checkOrder(order, orderService);
        String path;

        if(orderService.create(order)&&checkOrder){
            var session = request.getSession();
            session.setAttribute("order", order);
            path = JspHelper.getPath("order_created");
            LOGGER.info("Order [{}]", order);

        } else {
            request.setAttribute("isBooked",true);
            path = JspHelper.getPath("create_order");

        }

        return path;
    }
}
