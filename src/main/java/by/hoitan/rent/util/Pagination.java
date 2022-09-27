package by.hoitan.rent.util;

import by.hoitan.rent.bean.Car;
import by.hoitan.rent.bean.CarStatus;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

    public static void setAttributeToSession(HttpServletRequest request, int limit, CarServiceImpl carService) throws DAOException {
        var session = request.getSession();
        var page_number = request.getParameter("page_number");
        var currentPageNumber = page_number != null ? Integer.parseInt(page_number) : 1;
        var leftBorderCar = (limit*(currentPageNumber-1));
        var carList = carService.findAll();
        final var countCar = carList.size();
        final var maxNumberOfPage =(int) Math.ceil((double)countCar / limit);
        final List<Integer> page = new ArrayList<>();
        for (int i = 1; i <= maxNumberOfPage; i++) {
            page.add(i);
        }
        session.setAttribute("serviced", CarStatus.CAR_IS_SERVICED);
        session.setAttribute("cars", carService.findByLimit(leftBorderCar, limit));
        session.setAttribute("page_number", currentPageNumber);
        session.setAttribute("max_page", maxNumberOfPage);
        session.setAttribute("pages", page);

    }

    public static void setAttributeToSession(HttpServletRequest request, int limit, CarServiceImpl carService,String model) throws DAOException, ServiceException {
        var session = request.getSession();
        var page_number = request.getParameter("page_number");
        var currentPageNumber = page_number != null ? Integer.parseInt(page_number) : 1;
        var leftBorderCar = (limit*(currentPageNumber-1));
        var carList = carService.findByModel(model);
        final var countCar = carList.size();
        final var maxNumberOfPage =(int) Math.ceil((double)countCar / limit);
        final List<Integer> page = new ArrayList<>();
        for (int i = 1; i <= maxNumberOfPage; i++) {
            page.add(i);
        }
        session.setAttribute("cars", carList.subList(leftBorderCar,leftBorderCar+limit));
        session.setAttribute("page_number", currentPageNumber);
        session.setAttribute("max_page", maxNumberOfPage);
        session.setAttribute("pages", page);

    }
}
