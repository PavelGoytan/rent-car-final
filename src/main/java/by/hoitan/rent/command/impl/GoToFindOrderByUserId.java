package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.Order;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.service.impl.OrderServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoToFindOrderByUserId implements Command {

    private final OrderServiceImpl orderService = OrderServiceImpl.getInstance();

    private final CarServiceImpl carService = CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        var userId = request.getParameter("user_id");
        Map<Integer,String> map = new HashMap<>();
        var orderByUserId = orderService.findOrderByUserId(Integer.parseInt(userId));
        for (Order order : orderByUserId) {
            map.put(order.getId(), carService.findById(order.getCarId()).get().getRegistrationNumber()+" "+
                    carService.findById(order.getCarId()).get().getModel());
        }
        request.setAttribute("userOrders",orderByUserId);
        request.setAttribute("carModel", map);
        return JspHelper.getPath("user_order");
    }
}
