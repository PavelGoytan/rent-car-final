package by.hoitan.rent.dao;

import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.bean.User;
import by.hoitan.rent.dao.exception.DAOException;

import java.util.List;

public interface UserDAO {
//    void singIn(String user, String password) throws DAOException;
    boolean registration(User user) throws  DAOException;

    User singIn(String email, String password) throws DAOException;

    List<User> findAll() throws DAOException;
    User findById(int id);
    boolean changeRole(int id, RoleUser role);
    boolean changeStatus(int id, StatusUser status);

    boolean deleteUser (User user) throws DAOException;








}
