package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoToOrderCreated implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToOrderCreated.class);

    @Override
    public String execute(HttpServletRequest request) throws DAOException {

        return null;
    }
}
