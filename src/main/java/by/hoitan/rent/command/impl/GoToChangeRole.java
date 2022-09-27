package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.hoitan.rent.validator.UserChecker.*;
import java.util.Arrays;

public class GoToChangeRole implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToChangeRole.class);

    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        var id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idUser",id);
        String path;
        if (isManager(request)) {
            request.setAttribute("roles", Arrays.stream(RoleUser.values()).toArray());
            request.setAttribute("statuses", Arrays.stream(StatusUser.values()).toArray());
            path = JspHelper.getPath("change_role");
        } else if (isAdmin(request)) {
            request.setAttribute("statuses", Arrays.stream(StatusUser.values()).toArray());
            path = JspHelper.getPath("change_role");
        } else {
            path = JspHelper.getPath("home");
        }

        return path;
    }
}
