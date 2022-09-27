package by.hoitan.rent.bean;

public enum StatusUser {
    ACTIVE, BANNED, CONFIRMATION_AWAITING;

    public static StatusUser findStatus(int a){
       return StatusUser.values()[a-1];
    }
}
