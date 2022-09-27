package by.hoitan.rent.service;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.bean.User;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;

import java.util.List;

public interface ClientService {
    User singIn(String login, String password) throws ServiceException, DAOException;

    void singOut(String login) throws ServiceException;

    boolean registration(User user) throws ServiceException, DAOException;

    List<User> findAll() throws ServiceException, DAOException;

    boolean changeRole(int id, RoleUser role);

    boolean changeStatus(int id, StatusUser status);

    User findById(int id);

    boolean deleteUser(User user) throws ServiceException, DAOException;

}
