package by.hoitan.rent.bean;

public enum CarStatus {
    BOOKED, FREE, CAR_IS_SERVICED, IMPOSSIBLE_TO_RENT;

    public static CarStatus findCarStatus(int a){
        return CarStatus.values()[a-1];
    }
}
