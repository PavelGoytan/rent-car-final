package by.hoitan.rent.command.impl;


import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.ClientServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.hoitan.rent.validator.UserChecker.*;


public class DeleteUser implements Command {

    private static final Logger LOGGER = LogManager.getLogger(DeleteUser.class);

    private final ClientServiceImpl clientService = ClientServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        LOGGER.info("method execute()");
        var session = request.getSession();
        String path;
        if(isAdmin(request)|isManager(request)){
            var userID = request.getParameter("id");
            var user = clientService.findById(Integer.parseInt(userID));
            var deleteUser = clientService.deleteUser(user);

            request.setAttribute("users", clientService.findAll());
            path = JspHelper.getPath("all_user");
            LOGGER.info("User [{}] is deleted", user);
        } else {
            LOGGER.error("User [{}] has no access", session.getAttribute("user") );
            path = JspHelper.getPath("error_page");
        }

        return path;
    }
}
