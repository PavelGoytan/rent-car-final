package by.hoitan.rent.service;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car addNewCar(Car car) throws ServiceException, DAOException;
    void addEditCar(Car car) throws ServiceException;
    boolean updateCar(Car car) throws ServiceException, DAOException;

    Optional<Car> findById(int id);
    boolean deleteCar(int id) throws DAOException;
    List<Car> findByLimit(int leftBorderCar, int limitCarsOnPage) throws DAOException;

    List<Car> findByModel(String model) throws ServiceException, DAOException;
}
