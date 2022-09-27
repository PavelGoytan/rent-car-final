package by.hoitan.rent.validator.impl;

import by.hoitan.rent.validator.CheckParameter;
import by.hoitan.rent.validator.InputDataValidator;
import jakarta.servlet.http.HttpServletRequest;

public class CheckFirstName implements CheckParameter {

    private final InputDataValidator validator = InputDataValidator.getInstance();

    @Override
    public boolean execute(HttpServletRequest request) {
        var firstName = request.getParameter("first_name");
        if(firstName==null){
            return true;
        }
        if (validator.isValidName(firstName)){
            request.setAttribute("errorFName",0);
            request.setAttribute("firstName",firstName);
        } else {
            request.setAttribute("errorFName",1);
        }
        return validator.isValidName(firstName);
    }
}
