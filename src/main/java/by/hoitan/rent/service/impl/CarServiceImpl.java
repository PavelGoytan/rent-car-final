package by.hoitan.rent.service.impl;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.dao.impl.SQLCarDAO;
import by.hoitan.rent.service.CarService;
import by.hoitan.rent.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private final SQLCarDAO sqlCarDAO = SQLCarDAO.getInstance();

    private static final CarServiceImpl INSTANCE = new CarServiceImpl();

    private CarServiceImpl() {

    }

    public static CarServiceImpl getInstance(){
        return INSTANCE;
    }

    private final SQLCarDAO carDAO = SQLCarDAO.getInstance();

    public List<Car> findAll() throws DAOException {
        return carDAO.findAll();
    }

    @Override
    public Car addNewCar(Car car) throws ServiceException, DAOException {

        return  sqlCarDAO.create(car);

    }

    @Override
    public void addEditCar(Car car) throws ServiceException {

    }

    @Override
    public boolean updateCar(Car car) throws ServiceException, DAOException {
        return sqlCarDAO.update(car);
    }

    @Override
    public Optional<Car> findById(int id) {
        return carDAO.findById(id);
    }

    @Override
    public boolean deleteCar(int id) throws DAOException {
        return carDAO.deleteCar(id);
    }

    @Override
    public List<Car> findByLimit(int leftBorderCar, int limitCarsOnPage) throws DAOException {
        return sqlCarDAO.findByLimit(leftBorderCar,limitCarsOnPage);
    }

    @Override
    public List<Car> findByModel(String model) throws ServiceException, DAOException {
        var cars = findAll()
                .stream()
                .filter(car -> car.getModel().contains(model)
                        ||car.getRegistrationNumber().contains(model))
                .collect(Collectors.toList());
        return List.copyOf(cars);
    }
}
