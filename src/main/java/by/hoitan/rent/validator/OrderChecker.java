package by.hoitan.rent.validator;

import by.hoitan.rent.bean.Order;
import by.hoitan.rent.bean.OrderStatus;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.dao.impl.SQLOrderDAO;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.OrderServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderChecker {

    public static boolean checkOrder(Order order, OrderServiceImpl orderService) throws DAOException, ServiceException {
        var orderList = orderService.findByCarId(order.getCarId());
        var returnDateTime = order.getReturnDateTime();
        var rentDateTime = order.getRentDateTime();
            var orders = orderList.stream()
                    .filter(o->o.getOrderStatus().equals(OrderStatus.PAID))
                    .filter(o -> o.getRentDateTime().isBefore(rentDateTime)||o.getRentDateTime().isEqual(rentDateTime))
                    .filter(o -> o.getReturnDateTime().isAfter(rentDateTime))
                    .collect(Collectors.toList());
            return orders.size()<1;
        }
    }

