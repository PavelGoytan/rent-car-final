package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingOut implements Command {

    private static final Logger LOGGER = LogManager.getLogger(SingOut.class);

    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        LOGGER.info("method execute()");
        var session = request.getSession();
        session.setAttribute("user", null);
        session.invalidate();
        LOGGER.info("user signs out from the system");
        return JspHelper.getPath("sing_in");
    }
}
