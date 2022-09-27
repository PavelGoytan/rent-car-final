package by.hoitan.rent.command.impl;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.util.JspHelper;
import by.hoitan.rent.util.Pagination;
import jakarta.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GoToFindAllCarByLimit implements Command {

    private static final Logger LOGGER = LogManager.getLogger(GoToFindAllCarByLimit.class);

    private final CarServiceImpl carService = CarServiceImpl.getInstance();

    private final int LIMIT_CARS_ON_PAGE = 3;


    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {
//        var session = request.getSession();
//        var page_number = request.getParameter("page_number");
//        var currentPageNumber = page_number != null ? Integer.parseInt(page_number) : 1;
//        var leftBorderCar = (LIMIT_CARS_ON_PAGE*(currentPageNumber-1));
//        final var countCar = carService.findAll().size();
//        final var maxNumberOfPage =(int) Math.ceil((double)countCar / LIMIT_CARS_ON_PAGE);
//        final List<Integer> page = new ArrayList<>();
//        for (int i = 1; i <= maxNumberOfPage; i++) {
//            page.add(i);
//        }
//        session.setAttribute("cars", carService.findByLimit(leftBorderCar, LIMIT_CARS_ON_PAGE));
//        session.setAttribute("page_number", currentPageNumber);
//        session.setAttribute("max_page", maxNumberOfPage);
//        session.setAttribute("pages", page);
        Pagination.setAttributeToSession(request,LIMIT_CARS_ON_PAGE,carService);
        return JspHelper.getPath("all_car");
    }
}
