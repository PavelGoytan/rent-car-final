package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.bean.CarStatus;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.hoitan.rent.validator.UserChecker.*;

import java.math.BigDecimal;

public class UpdateCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    private final CarServiceImpl carService = CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {

        String path;
        if (isAdmin(request) | isManager(request)) {
            var car = Car.builder().id(Integer.parseInt(request.getParameter("carID")))
                    .registrationNumber(request.getParameter("registration_number"))
                    .cost(BigDecimal.valueOf(Double.parseDouble(request.getParameter("cost"))))
                    .model(request.getParameter("model"))
                    .carStatus(CarStatus.valueOf(request.getParameter("car_status")))
                    .build();

//todo checker add car form
            if (carService.updateCar(car)) {
                request.setAttribute("cars", carService.findAll());
                path = JspHelper.getPath("all_car");
            } else {
                path = JspHelper.getPath("create_car");
            }
        } else {
            path = JspHelper.getPath("error_page");
        }
        return path;
    }
}
