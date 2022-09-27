package by.hoitan.rent.dao.exception;

import java.sql.SQLException;

public class DAOException extends Exception {
    private static final long serialVersionUID = 1L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message, SQLException e) {
        super(message, e);
    }
}
