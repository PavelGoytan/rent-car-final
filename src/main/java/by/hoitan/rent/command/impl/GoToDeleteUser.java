package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.User;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.ClientServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.hoitan.rent.validator.UserChecker.*;


public class GoToDeleteUser implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToDeleteUser.class);

    private final ClientServiceImpl clientService = ClientServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        String path;
        if(isAdmin(request)|isManager(request)){
            var id = request.getParameter("id");
            var user = clientService.findById(Integer.parseInt(id));
            request.setAttribute("user", user);
            request.setAttribute("userID", id);
            path = JspHelper.getPath("delete_user");
        } else {
            path = JspHelper.getPath("error_page");
        }

        return path;
    }
}
