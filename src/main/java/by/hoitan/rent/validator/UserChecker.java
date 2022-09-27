package by.hoitan.rent.validator;

import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class UserChecker {

    public static boolean isUser(HttpServletRequest request){
        var session = request.getSession();
        var user = (User)session.getAttribute("user");
        return user!=null&&user.getRoleUser()==RoleUser.CLIENT;
    }
    public static boolean isAdmin(HttpServletRequest request){
        var session = request.getSession();
        var user = (User)session.getAttribute("user");
        return user!=null&&user.getRoleUser()==RoleUser.ADMIN;
    }
    public static boolean isAdmin(User user){
        return user!=null&&user.getRoleUser()==RoleUser.ADMIN;
    }
    public static boolean isManager(HttpServletRequest request){
        var session = request.getSession();
        var user = (User)session.getAttribute("user");
        return user!=null&&user.getRoleUser()==RoleUser.MANAGER;
    }
    public static boolean isManager(User user){
        return user!=null&&user.getRoleUser()==RoleUser.MANAGER;
    }

    public static boolean isManagerAndAdmin(HttpServletRequest request){
        return isManager(request)|isAdmin(request);
    }

    public static User getUser(HttpServletRequest request){
        var session = request.getSession();
        var user = (User)session.getAttribute("user");
        return user;
    }

}
