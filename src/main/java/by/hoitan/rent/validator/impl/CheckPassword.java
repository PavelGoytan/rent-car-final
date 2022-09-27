package by.hoitan.rent.validator.impl;

import by.hoitan.rent.validator.CheckParameter;
import by.hoitan.rent.validator.InputDataValidator;
import jakarta.servlet.http.HttpServletRequest;

public class CheckPassword implements CheckParameter {

    private final InputDataValidator validator = InputDataValidator.getInstance();

    @Override
    public boolean execute(HttpServletRequest request) {
        var password = request.getParameter("password");
        if(password==null){
            return true;
        } else if (validator.isValidPassword(password)){
            request.setAttribute("errorPas",0);
        } else {
            request.setAttribute("errorPas",1);
        }
        return validator.isValidPassword(password);
    }
}
