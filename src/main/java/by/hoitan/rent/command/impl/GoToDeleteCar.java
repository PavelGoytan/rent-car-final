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


public class GoToDeleteCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToDeleteCar.class);

    private final CarServiceImpl carService = CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        String path;
        if(isAdmin(request)|isManager(request)){
            var id = (request.getParameter("id"));
            var car = carService.findById(Integer.parseInt(id));
            request.setAttribute("car",car);
            request.setAttribute("carID",id);
            path = JspHelper.getPath("delete_car");
        } else {
            path = JspHelper.getPath("error_page");
        }


        return path;
    }
}
