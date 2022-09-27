package by.hoitan.rent.command.impl;


import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.service.impl.ClientServiceImpl;
import by.hoitan.rent.util.JspHelper;
import by.hoitan.rent.util.Pagination;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;


public class SingIn implements Command {

    private static final Logger LOGGER = LogManager.getLogger(SingIn.class);

    private final ClientServiceImpl clientService = ClientServiceImpl.getInstance();

    private  final CarServiceImpl carService = CarServiceImpl.getInstance();

    private final int LIMIT_CARS_ON_PAGE = 3;

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        LOGGER.info("method execute()");
        var email = request.getParameter("email");
        var password = request.getParameter("password");
        var user = clientService.singIn(email, password);
        var session = request.getSession();
        String today= LocalDate.now().toString();
        session.setAttribute("today",today);
        String path;
        if (user!=null){
            session.setAttribute("user", user);
            switch (user.getRoleUser()) {
                case CLIENT -> session.setAttribute("isClient", true);
                case MANAGER -> session.setAttribute("isManager", true);
                case ADMIN -> session.setAttribute("isAdmin", true);
            }
            var roleUser = user.getRoleUser();
            var statusUser = user.getStatusUser();
            session.setAttribute("role", roleUser);
            session.setAttribute("status",statusUser);
            var firstName = user.getFirstName()+" ( " +user.getEmailLogin() + " )!";
            session.setAttribute("login",firstName);
            session.setAttribute("cars", carService.findAll());
            Pagination.setAttributeToSession(request, LIMIT_CARS_ON_PAGE, carService);
            path = JspHelper.getPath("home");
            LOGGER.info("user signs in the system");
        } else {
            LOGGER.info("user is not found");
            session.setAttribute("error", 1);
            path = JspHelper.getPath("sing_in");
        }
        return path;
    }


    //todo banned
    //todo test


}
