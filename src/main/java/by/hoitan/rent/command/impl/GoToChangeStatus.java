package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;

public class GoToChangeStatus implements Command {
    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {

        var id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idUser",id);
        request.setAttribute("statuses", Arrays.stream(StatusUser.values()).toArray());
        return JspHelper.getPath("change_status");
    }
}
