package by.hoitan.rent.service;

import by.hoitan.rent.bean.Order;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {


    Optional<Order> findById(int id) throws ServiceException, DAOException;

    List<Order> findAll() throws ServiceException;

    boolean create(Order order) throws ServiceException;


    boolean update(Order order) throws ServiceException, DAOException;


    void delete(Order order) throws ServiceException;


    double countOrders() throws ServiceException;


    double countOrders(long userId) throws ServiceException;


    List<Order> findByLimit(int leftBorderUsers, int limitOrdersOnPage) throws ServiceException;

    long add(Map<String, String> parameters) throws ServiceException;


    List<Order> findByCarId(int id) throws ServiceException, DAOException;

    List<Order> findOrderByUserId(int userID) throws ServiceException, DAOException;


    List<Order> findByUserIdAndLimit(Long userId, int leftBorderCars, int limitOrdersOnPage) throws ServiceException;

}
