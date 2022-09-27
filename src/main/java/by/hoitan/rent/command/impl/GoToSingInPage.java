package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoToSingInPage implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToSingInPage.class);

    @Override
    public String execute(HttpServletRequest request) throws DAOException {
//        var session = request.getSession();
//        session.setAttribute("guest",true);
        return JspHelper.getPath("sing_in");
    }
}
