package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.User;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.ClientServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class FindUserById implements Command {

    private final ClientServiceImpl clientService = ClientServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        var userId = Integer.parseInt(request.getParameter("user_id"));
        var user = clientService.findById(userId);
        if(user!=null){
            List<User> users = new ArrayList<>();
            users.add(user);
            request.setAttribute("users",users);
        } else {
            request.setAttribute("users",clientService.findAll());
            request.setAttribute("massage", "User with ID:"+userId+"is not fond");
        }

        return JspHelper.getPath("all_user");
    }
}
