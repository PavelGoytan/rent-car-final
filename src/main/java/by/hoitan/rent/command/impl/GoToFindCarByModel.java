package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;

public class GoToFindCarByModel implements Command {
    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        return JspHelper.getPath("find_car");
    }
}
