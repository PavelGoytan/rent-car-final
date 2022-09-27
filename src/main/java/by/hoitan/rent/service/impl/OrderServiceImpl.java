package by.hoitan.rent.service.impl;

import by.hoitan.rent.bean.Order;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.dao.impl.SQLOrderDAO;
import by.hoitan.rent.service.OrderService;
import by.hoitan.rent.service.exception.ServiceException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();

    private final SQLOrderDAO orderDAO = SQLOrderDAO.getInstance();

    private OrderServiceImpl() {
    }

    public static OrderServiceImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public Optional<Order> findById(int id) throws ServiceException, DAOException {
        return orderDAO.findById(id);
    }

    @Override
    public List<Order> findAll() throws ServiceException {
        return null;
    }

    @Override
    public boolean create(Order order) throws ServiceException {
        boolean isCreate;
        try {
            isCreate = orderDAO.create(order);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return isCreate;
    }

    @Override
    public boolean update(Order order) throws ServiceException, DAOException {

        return orderDAO.update(order);
    }

    @Override
    public void delete(Order order) throws ServiceException {

    }

    @Override
    public double countOrders() throws ServiceException {
        return 0;
    }

    @Override
    public double countOrders(long userId) throws ServiceException {
        return 0;
    }

    @Override
    public List<Order> findByLimit(int leftBorderUsers, int limitOrdersOnPage) throws ServiceException {
        return null;
    }

    @Override
    public long add(Map<String, String> parameters) throws ServiceException {
        return 0;
    }

    @Override
    public List<Order> findByCarId(int id) throws ServiceException, DAOException {
        return orderDAO.findByIdCarId(id);
    }

    @Override
    public List<Order> findOrderByUserId(int userID) throws ServiceException, DAOException {
        return orderDAO.findOrderByUserId(userID);
    }

    @Override
    public List<Order> findByUserIdAndLimit(Long userId, int leftBorderCars, int limitOrdersOnPage) throws ServiceException {
        return null;
    }
}
