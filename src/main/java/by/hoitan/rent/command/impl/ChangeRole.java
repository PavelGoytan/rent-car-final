package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.bean.User;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.impl.ClientServiceImpl;
import by.hoitan.rent.util.JspHelper;
import static by.hoitan.rent.validator.UserChecker.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangeRole implements Command {

    private static final Logger LOGGER = LogManager.getLogger(ChangeRole.class);
    private final ClientServiceImpl clientService = ClientServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        LOGGER.info("method execute()");
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        String path;
        if(isManager(request)){
            var role = request.getParameter("role");
            var status = request.getParameter("status");
            var changeRole = clientService.changeRole(idUser, RoleUser.valueOf(role));
            var changeStatus = clientService.changeStatus(idUser, StatusUser.valueOf(status));
            var clientServiceById = clientService.findById(idUser);
            request.setAttribute("changedUser",clientServiceById);
            path = JspHelper.getPath("changed_user");
            LOGGER.info("role is changed to [{}]", clientServiceById.getRoleUser());
        } else if (isAdmin(request)){
            var status = request.getParameter("status");
            var changeStatus = clientService.changeStatus(idUser, StatusUser.valueOf(status));
            var clientServiceById = clientService.findById(idUser);
            request.setAttribute("changedUser",clientServiceById);
            path = JspHelper.getPath("changed_user");
            LOGGER.info("status is changed to [{}]", clientServiceById.getStatusUser());
        } else {
            path = JspHelper.getPath("home");
            LOGGER.error("user have no access");
        }
        return path;
    }
}
