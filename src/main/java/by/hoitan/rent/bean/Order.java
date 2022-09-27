package by.hoitan.rent.bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private int id;
    private BigDecimal price;
    private LocalDate rentDateTime;
    private LocalDate returnDateTime;
    private int carId;
    private int userId;
    private OrderStatus orderStatus;

    private Order(OrderBuilder orderBuilder) {
        this.id = orderBuilder.id;
        this.price = orderBuilder.price;
        this.rentDateTime = orderBuilder.rentDateTime;
        this.returnDateTime = orderBuilder.returnDateTime;
        this.carId = orderBuilder.carId;
        this.userId = orderBuilder.userId;
        this.orderStatus = orderBuilder.orderStatus;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getRentDateTime() {
        return rentDateTime;
    }

    public LocalDate getReturnDateTime() {
        return returnDateTime;
    }

    public int getCarId() {
        return carId;
    }

    public int getUserId() {
        return userId;
    }

    public OrderStatus getOrderStatus() {

        return orderStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRentDateTime(LocalDate rentDateTime) {
        this.rentDateTime = rentDateTime;
    }

    public void setReturnDateTime(LocalDate returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && carId == order.carId && userId == order.userId && Objects.equals(price, order.price) && Objects.equals(rentDateTime, order.rentDateTime) && Objects.equals(returnDateTime, order.returnDateTime) && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, rentDateTime, returnDateTime, carId, userId, orderStatus);
    }

    @Override
    public String toString() {
        return "Order №" + id + "<br>" +
                "Price: " + price + "<br>" +
                "Rent Date Time=" + rentDateTime + "<br>" +
                "Return DateTime=" + returnDateTime + "<br>" +
                "Order Status: " + orderStatus
                ;
    }

    public static class OrderBuilder {
        private int id;
        private BigDecimal price;
        private LocalDate rentDateTime;
        private LocalDate returnDateTime;
        private int carId;
        private int userId;
        private OrderStatus orderStatus;

        public OrderBuilder() {
        }

        public OrderBuilder id(int id) {
            this.id = id;
            return this;
        }

        public OrderBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public OrderBuilder rentDateTime(LocalDate rentDateTime) {
            this.rentDateTime = rentDateTime;
            return this;
        }

        public OrderBuilder returnDateTime(LocalDate returnDateTime) {
            this.returnDateTime = returnDateTime;
            return this;
        }

        public OrderBuilder carId(int carId) {
            this.carId = carId;
            return this;
        }

        public OrderBuilder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public OrderBuilder orderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Order build() {
            return (new Order(this));
        }
    }

}
