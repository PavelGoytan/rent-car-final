package by.hoitan.rent.bean;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private Integer id;
    private CarStatus carStatus;
    private BigDecimal cost;
    private String model;
    private String registrationNumber;


    private Car(CarBuilder carBuilder) {
        this.id = carBuilder.id;
        this.carStatus = carBuilder.carStatus;
        this.cost = carBuilder.cost;
        this.model = carBuilder.model;
        this.registrationNumber = carBuilder.registrationNumber;

    }

    public static CarBuilder builder(){
        return new CarBuilder();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carStatus=" + carStatus +
                ", cost=" + cost +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    public static class CarBuilder{
        private Integer id;
        private CarStatus carStatus;
        private BigDecimal cost;
        private String model;
        private String registrationNumber;

        public CarBuilder() {
        }

        public CarBuilder id(int id){
            this.id = id;
            return this;
        }
        public CarBuilder carStatus(CarStatus carStatus){
            this.carStatus = carStatus;
            return this;
        }
        public CarBuilder cost(BigDecimal cost){
            this.cost = cost;
            return this;
        }
        public CarBuilder model(String model){
            this.model = model;
            return this;
        }
        public CarBuilder registrationNumber(String registrationNumber){
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }
}
