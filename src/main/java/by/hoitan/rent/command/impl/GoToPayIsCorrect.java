package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.bean.Order;
import by.hoitan.rent.bean.OrderStatus;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.service.impl.OrderServiceImpl;
import by.hoitan.rent.util.JspHelper;
import by.hoitan.rent.validator.ParameterRegistration;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public class GoToPayIsCorrect implements Command {

    private final OrderServiceImpl orderService = OrderServiceImpl.getInstance();

    private final CarServiceImpl carService = CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {

        int count = 0;
        String path;
        for (ParameterRegistration parameter : ParameterRegistration.values()) {
            var par = parameter.toString().toLowerCase();
            var execute = parameter.getParameter().execute(request);
            if (!execute) {
                count++;
            }
        }
        if (count == 0) {
            var orderID = request.getParameter("orderID");
            var order = orderService.findById(Integer.parseInt(orderID));
            order.get().setOrderStatus(OrderStatus.PAID);
            var update = orderService.update(order.get());
            var car = carService.findById(order.get().getCarId());
            if (update) {
                request.setAttribute("massage", "YOUR ORDER№" + order.get().getId()
                        + " is accepted\\nYOUR CAR IS "
                        + car.get().getModel()
                        + " , REGISTRATION NUMBER: " + car.get().getRegistrationNumber()
                        + "\\nRENT DATE FROM " + order.get().getRentDateTime() + " TO "
                        + order.get().getReturnDateTime());
                path = JspHelper.getPath("success_rent");

            } else {
                request.setAttribute("massage", "YOUR ORDER№" + order.get().getId()
                        + " is not accepted");
                path = JspHelper.getPath("success_rent");

            }
        } else {
            request.setAttribute("massage", "WRONG DATA");
            path = JspHelper.getPath("order_created");
        }
        return path;
    }
}
