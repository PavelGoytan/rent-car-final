package by.hoitan.rent.command.impl;

import by.hoitan.rent.bean.CarStatus;
import by.hoitan.rent.bean.User;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoToCreateOrderPage implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToCreateOrderPage.class);

    private final CarServiceImpl carService = CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException {

        String path;

        var id = request.getParameter("id");
        var session = request.getSession();

        var user = (User)session.getAttribute("user");

        if (id != null&&user!=null) {
            var car = carService.findById(Integer.parseInt(id)).get();
            if(!car.getCarStatus().equals(CarStatus.CAR_IS_SERVICED)
            &&!car.getCarStatus().equals(CarStatus.IMPOSSIBLE_TO_RENT)) {
                session.setAttribute("car", car);
                path = JspHelper.getPath("create_order");
            } else {
                request.setAttribute("massage", "Car "+ car + "IS BOOKED");
                request.setAttribute("modelName", car.getModel());
                request.setAttribute("modelNumber", car.getRegistrationNumber());
//                var cars = carService.findAll();
//                request.setAttribute("cars", cars);
                path = JspHelper.getPath("home");
            }
        } else if(user==null){
//            var cars = carService.findAll();
//            request.setAttribute("cars", cars);
            path = JspHelper.getPath("sing_in");
        } else {
            path = path = JspHelper.getPath("all_car");
        }
        return path;
    }
}
