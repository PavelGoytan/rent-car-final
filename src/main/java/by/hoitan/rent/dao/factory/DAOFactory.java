package by.hoitan.rent.dao.factory;

import by.hoitan.rent.dao.impl.SQLCarDAO;
import by.hoitan.rent.dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final SQLCarDAO sqlCarDAO = SQLCarDAO.getInstance();
    private final SQLUserDAO sqlUserDAO = SQLUserDAO.getInstance();

    public DAOFactory getInstance(){
        return instance;
    }

    public SQLCarDAO getSqlCarDAO() {
        return sqlCarDAO;
    }

    public SQLUserDAO getSqlUserDAO() {
        return sqlUserDAO;
    }
}
