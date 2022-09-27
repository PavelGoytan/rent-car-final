package by.hoitan.rent.service.impl;

import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.bean.User;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.dao.impl.SQLUserDAO;
import by.hoitan.rent.service.ClientService;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.validator.CreateUserValidation;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private static final ClientServiceImpl INSTANCE = new ClientServiceImpl();

    private final CreateUserValidation createUserValidation = new CreateUserValidation();
    private final SQLUserDAO sqlUserDAO = SQLUserDAO.getInstance();

    private ClientServiceImpl() {
    }

    public static ClientServiceImpl getInstance() {
        return INSTANCE;

    }

    @Override
    public User singIn(String login, String password) throws DAOException {
        return sqlUserDAO.singIn(login, password);
    }

    @Override
    public void singOut(String login) {

    }

    @Override
    public boolean registration(User user) throws ServiceException, DAOException {
        return sqlUserDAO.registration(user);
    }

    @Override
    public List<User> findAll() throws DAOException {
        return sqlUserDAO.findAll();
    }

    @Override
    public boolean changeRole(int id, RoleUser role) {
        return sqlUserDAO.changeRole(id, role);
    }

    @Override
    public boolean changeStatus(int id, StatusUser status) {
        return sqlUserDAO.changeStatus(id, status);
    }

    @Override
    public User findById(int id) {
        return sqlUserDAO.findById(id);
    }

    @Override
    public boolean deleteUser(User user) throws DAOException {
        return sqlUserDAO.deleteUser(user);
    }

}
