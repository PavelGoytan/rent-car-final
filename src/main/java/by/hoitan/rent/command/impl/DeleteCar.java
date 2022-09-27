package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.hoitan.rent.validator.UserChecker.*;


public class DeleteCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger(DeleteCar.class);
    private final CarServiceImpl carService = CarServiceImpl.getInstance();


    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        LOGGER.info("method  execute()");
        String path;
        if (isAdmin(request) | isManager(request)) {
            var carID = request.getParameter("id");

            var deleteCar = carService.deleteCar(Integer.parseInt(carID));

            request.setAttribute("cars", carService.findAll());
            path = JspHelper.getPath("all_car");
            LOGGER.info("Car [{}] is deleted ",
                    carID);
        } else {
            path = JspHelper.getPath("error_page");
        }
        return path;
    }
}
