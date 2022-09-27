package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.bean.CarStatus;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.util.JspHelper;
import by.hoitan.rent.validator.ParameterRegistration;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.hoitan.rent.validator.UserChecker.*;


import java.math.BigDecimal;
import java.util.Arrays;

public class CreateCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger(CreateCar.class);
    private final CarServiceImpl carService = CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        LOGGER.info("method execute()");
        request.setAttribute("car_statuses", Arrays.stream(CarStatus.values()).toArray());

        String path;
        int count = 0;
        for (ParameterRegistration parameter : ParameterRegistration.values()) {
            var par = parameter.toString().toLowerCase();
            var execute = parameter.getParameter().execute(request);
            if (!execute) {
                count++;
            }
        }
        if (count == 0 && (isAdmin(request) | isManager(request))) {
            var car = Car.builder().registrationNumber(request.getParameter("registration_number"))
                    .cost(BigDecimal.valueOf(Double.parseDouble(request.getParameter("cost"))))
                    .model(request.getParameter("model"))
                    .carStatus(CarStatus.valueOf(request.getParameter("car_status")))
                    .build();

            if (carService.addNewCar(car) != null) {
                request.setAttribute("cars", carService.findAll());
                path = JspHelper.getPath("all_car");
                LOGGER.info("Car[{}] is created", car);
            } else {
                LOGGER.info("Car is not created");
                path = JspHelper.getPath("create_car");
            }
        } else if (count != 0) {
            path = JspHelper.getPath("create_car");
        } else {
            LOGGER.error("user have no access");
            path = JspHelper.getPath("error_page");
        }

        return path;
    }
}
