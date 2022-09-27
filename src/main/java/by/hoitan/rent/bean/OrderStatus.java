package by.hoitan.rent.bean;

public enum OrderStatus {
    PAID, AWAITS_PAYMENT, DECLINED;

    public static OrderStatus findOrderStatus(int a){
        return OrderStatus.values()[a-1];
    }
}
