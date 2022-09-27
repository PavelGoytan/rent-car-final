package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.impl.ClientServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import static by.hoitan.rent.validator.UserChecker.*;

public class GoToFindAllUser implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToFindAllUser.class);


    private final ClientServiceImpl clientService = ClientServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        LOGGER.info("method execute()");
        var manager = isManager(request);
        var admin = isAdmin(request);
        String path;
        if (manager||admin) {
            request.setAttribute("users", clientService.findAll());
            path = JspHelper.getPath("all_user");
            LOGGER.info("Find all user is completed");
        } else {
            LOGGER.info("User  has no access");
            path = JspHelper.getPath("error_page");
        }
        return path;
    }
}
