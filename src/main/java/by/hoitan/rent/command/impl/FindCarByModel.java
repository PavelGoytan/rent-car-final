package by.hoitan.rent.command.impl;


import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class FindCarByModel implements Command {

    private final CarServiceImpl carService = CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
        var session = request.getSession();
        var car = request.getParameter("model_car");
        var cars = carService.findByModel(car);
        if (cars.size()==0){
            request.setAttribute("massage", "Car " + car + " is not found");
        } else {
            request.setAttribute("cars",cars);
        }


        return JspHelper.getPath("find_car");
    }
}
