package by.hoitan.rent.dao;

import by.hoitan.rent.bean.Order;
import by.hoitan.rent.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    List<Order> findByLimit(int leftBorder, int numberOfLines) throws DAOException;

    List<Order> findAll() throws DAOException;

    Optional<Order> findById(int id) throws DAOException;

    List<Order> findByIdCarId(int carId) throws DAOException;

    boolean create(Order order) throws DAOException;

    boolean update(Order order) throws DAOException;

    void delete(Order order) throws DAOException;

    List<Order> findOrderByUserId(int userId);

    List<Order> findByUserIdAndLimit(Long userId, int leftBorderCars, int limitOrdersOnPage) throws DAOException;


}
