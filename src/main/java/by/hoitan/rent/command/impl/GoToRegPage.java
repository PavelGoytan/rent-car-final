package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class GoToRegPage implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToRegPage.class);

    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        request.setAttribute("roles", Arrays.stream(RoleUser.values()).toArray());
        request.setAttribute("statuses", Arrays.stream(StatusUser.values()).toArray());
        return JspHelper.getPath("registration");
    }
}
