package by.hoitan.rent.bean;

public enum RoleUser {
    CLIENT, MANAGER, ADMIN;

    public static RoleUser findRole(int a){
         var values = RoleUser.values();
         return values[a-1];
    }
}
