package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.CarStatus;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.hoitan.rent.validator.UserChecker.*;


import java.util.Arrays;

public class GoToCreateCarPage implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToCreateCarPage.class);

    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        String path;
        if(isAdmin(request)|isManager(request)){
            request.setAttribute("car_statuses", Arrays.stream(CarStatus.values()).toArray());
            path = JspHelper.getPath("create_car");
        } else {
            path = JspHelper.getPath("error_page");
        }
        request.setAttribute("car_statuses", Arrays.stream(CarStatus.values()).toArray());
        return path;
    }
}
