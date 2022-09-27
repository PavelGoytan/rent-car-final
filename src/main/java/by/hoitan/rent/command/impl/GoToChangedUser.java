package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import jakarta.servlet.http.HttpServletRequest;

public class GoToChangedUser implements Command {
    @Override
    public String execute(HttpServletRequest request) throws DAOException {
        return null;
    }
}
