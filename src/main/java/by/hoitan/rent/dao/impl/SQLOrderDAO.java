package by.hoitan.rent.dao.impl;

import by.hoitan.rent.bean.Order;
import by.hoitan.rent.bean.OrderStatus;
import by.hoitan.rent.dao.OrderDAO;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.pool.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class SQLOrderDAO implements OrderDAO {

    private final String CREATE_ORDER = """
            INSERT INTO orders(price, rent_date, return_date, car_id, user_id, status_id)
            VALUES (?,?,?,?,?,?);
            """;

    private static final SQLOrderDAO INSTANCE = new SQLOrderDAO();

    private SQLOrderDAO() {

    }

    public static SQLOrderDAO getInstance() {
        return INSTANCE;
    }


    @Override
    public List<Order> findByLimit(int leftBorder, int numberOfLines) throws DAOException {
        return null;
    }

    @Override
    public List<Order> findAll() throws DAOException {

        return null;
    }

    @Override
    public Optional<Order> findById(int id) throws DAOException {
        try(var connection = ConnectionManager.getConnection();
            var preparedStatement = connection.prepareStatement(QueryDAO.FIND_ORDER_BY_ID)){
            preparedStatement.setInt(1,id);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                var order = Order.builder().id(resultSet.getInt("id"))
                        .price(resultSet.getBigDecimal("price"))
                        .rentDateTime(resultSet.getDate("rent_date").toLocalDate())
                        .returnDateTime(resultSet.getDate("return_date").toLocalDate())
                        .carId(resultSet.getInt("car_id"))
                        .userId(resultSet.getInt("user_id"))
                        .orderStatus(OrderStatus.findOrderStatus(resultSet.getInt("status_id")))
                        .build();
                return Optional.of(order);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Order> findByIdCarId(int carId) throws DAOException {
        List<Order> orders  = new ArrayList<>();
        try(var connection = ConnectionManager.getConnection();
            var preparedStatement = connection.prepareStatement(QueryDAO.FIND_ALL_ORDERS_BY_CAR_ID)){
            createListOrders(carId, orders, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public boolean create(Order order) throws DAOException {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(CREATE_ORDER, RETURN_GENERATED_KEYS)) {
            preparedStatement.setBigDecimal(1, order.getPrice());
            preparedStatement.setObject(2, order.getRentDateTime());
            preparedStatement.setObject(3, order.getReturnDateTime());
            preparedStatement.setInt(4, order.getCarId());
            preparedStatement.setInt(5, order.getUserId());
            preparedStatement.setInt(6, order.getOrderStatus().ordinal() + 1);

            var executeUpdate = preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            }
            return executeUpdate>0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean update(Order order) throws DAOException {
        try(var connection = ConnectionManager.getConnection();
            var preparedStatement = connection.prepareStatement(QueryDAO.UPDATE_ORDER)){
            preparedStatement.setBigDecimal(1,order.getPrice());
            preparedStatement.setDate(2, Date.valueOf(order.getRentDateTime()));
            preparedStatement.setDate(3, Date.valueOf(order.getReturnDateTime()));
            preparedStatement.setInt(4,order.getOrderStatus().ordinal()+1);
            preparedStatement.setInt(5,order.getId());

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Order order) throws DAOException {

    }

    @Override
    public List<Order> findOrderByUserId(int userId) {
        List<Order> orders  = new ArrayList<>();
        try(var connection = ConnectionManager.getConnection();
            var preparedStatement = connection.prepareStatement(QueryDAO.FIND_ORDER_BY_USER_ID)){
            createListOrders(userId, orders, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    private void createListOrders(int userId, List<Order> orders, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1,userId);
        var resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            orders.add(new Order.OrderBuilder()
                    .id(resultSet.getInt("id"))
                    .rentDateTime(resultSet.getDate("rent_date").toLocalDate())
                    .returnDateTime(resultSet.getDate("return_date").toLocalDate())
                    .carId(resultSet.getInt("car_id"))
                    .userId(resultSet.getInt("user_id"))
                    .price(resultSet.getBigDecimal("price"))
                    .orderStatus(OrderStatus.findOrderStatus(resultSet.getInt("status_id")))
                    .build());
        }
    }

    @Override
    public List<Order> findByUserIdAndLimit(Long userId, int leftBorderCars, int limitOrdersOnPage) throws DAOException {

        return null;
    }
}
