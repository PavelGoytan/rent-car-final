package by.hoitan.rent.service.factory;

import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.service.impl.ClientServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final CarServiceImpl carService = CarServiceImpl.getInstance();
    private final ClientServiceImpl clientService = ClientServiceImpl.getInstance();

    public static ServiceFactory getInstance(){
        return instance;
    }

    public CarServiceImpl getCarService() {
        return carService;
    }

    public ClientServiceImpl getClientService() {
        return clientService;
    }
}
