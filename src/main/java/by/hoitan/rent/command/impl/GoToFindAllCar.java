package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoToFindAllCar implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToFindAllCar.class);

    private final CarServiceImpl carService = CarServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        LOGGER.info("method execute()");
        request.setAttribute("cars", carService.findAll());
        return JspHelper.getPath("all_car");
    }
}
