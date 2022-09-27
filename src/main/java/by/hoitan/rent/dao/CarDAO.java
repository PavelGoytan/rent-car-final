package by.hoitan.rent.dao;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;


public interface CarDAO {
    void addCar(Car car) throws DAOException;

    boolean deleteCar(int id) throws DAOException;

    void delete(Car car) throws DAOException;

    List<Car> findAll() throws DAOException;
    List<Car> findByModel(String model) throws DAOException;
    Optional<Car> findById(int id);
    List<Car> findByLimit(int leftBorderCar, int limitCarsOnPage) throws DAOException;
    boolean update(Car car) throws DAOException;
    Car create(Car car) throws DAOException;

}
