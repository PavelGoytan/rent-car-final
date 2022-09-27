package by.hoitan.rent.dao.impl;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.bean.CarStatus;
import by.hoitan.rent.dao.CarDAO;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.pool.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.hoitan.rent.dao.impl.QueryDAO.*;
import static java.sql.Statement.*;

public class SQLCarDAO implements CarDAO {
    private final String FIND_ALL = """
            SELECT*
            FROM cars
            JOIN status_car ON cars.car_status = status_car.id;;
            """;
    private static final SQLCarDAO INSTANCE = new SQLCarDAO();

    private SQLCarDAO() {
    }

    @Override
    public void addCar(Car car) throws DAOException {

    }

    @Override
    public boolean deleteCar(int id) throws DAOException {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(DELETE_CAR)) {

            preparedStatement.setInt(1, id);
            var executeUpdate = preparedStatement.executeUpdate();
            return executeUpdate > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Car car) throws DAOException {

    }

    @Override
    public List<Car> findAll() throws DAOException {
        List<Car> car = new ArrayList<>();
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(QueryDAO.FIND_ALL_CARS)) {
            carFromResultSet(car, preparedStatement);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return car;
    }

    @Override
    public List<Car> findByModel(String model) throws DAOException {
        List<Car> carList = new ArrayList<>();
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(FIND_BY_MODEL)) {
            preparedStatement.setString(1, model);
            carFromResultSet(carList,preparedStatement);
        } catch (SQLException e) {
            throw new DAOException();
        }
        return carList;
    }

    @Override
    public Optional<Car> findById(int id) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_CAR)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var car = Car.builder().id(resultSet.getInt("id"))
                        .registrationNumber(resultSet.getString("registration_number"))
                        .cost(resultSet.getBigDecimal("cost"))
                        .carStatus(CarStatus.findCarStatus(Integer.parseInt(resultSet.getString("car_status"))))
                        .model(resultSet.getString("model")).build();

                return Optional.of(car);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Car> findByLimit(int leftBorderCar, int limitCarsOnPage) throws DAOException {
        List<Car> car = new ArrayList<>();
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(FIND_BY_LIMIT)) {
            preparedStatement.setInt(1, leftBorderCar);
            preparedStatement.setInt(2, limitCarsOnPage);
            carFromResultSet(car, preparedStatement);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return car;
    }

    private void carFromResultSet(List<Car> car, PreparedStatement preparedStatement) throws SQLException {
        var resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            car.add(new Car.CarBuilder()
                    .id(resultSet.getInt("id"))
                    .carStatus(CarStatus.findCarStatus(Integer.parseInt(resultSet.getString("car_status"))))
                    .cost(resultSet.getBigDecimal("cost"))
                    .model(resultSet.getString("model"))
                    .registrationNumber(resultSet.getString("registration_number"))
                    .build());
        }
    }

    @Override
    public boolean update(Car car) throws DAOException {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(UPDATE_CAR)) {
            preparedStatement.setString(1, car.getRegistrationNumber());
            preparedStatement.setBigDecimal(2, car.getCost());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setInt(4, car.getCarStatus().ordinal() + 1);
            preparedStatement.setInt(5, car.getId());

            var executeUpdate = preparedStatement.executeUpdate();

            return executeUpdate > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car create(Car car) throws DAOException {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(CREATE_CAR, RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, car.getRegistrationNumber());
            preparedStatement.setBigDecimal(2, car.getCost());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setInt(4, car.getCarStatus().ordinal() + 1);
            var executeUpdate = preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();

            if (executeUpdate > 0 && generatedKeys.next()) {
                car.setId(generatedKeys.getInt(1));
            }
            return car;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static SQLCarDAO getInstance() {
        return INSTANCE;
    }
}
