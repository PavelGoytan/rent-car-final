package by.hoitan.rent.validator.impl;

import by.hoitan.rent.validator.CheckParameter;
import by.hoitan.rent.validator.InputDataValidator;
import jakarta.servlet.http.HttpServletRequest;

public class CheckLastName implements CheckParameter {

    private final InputDataValidator validator = InputDataValidator.getInstance();

    @Override
    public boolean execute(HttpServletRequest request) {
        var lastName = request.getParameter("last_name");
        if(lastName==null){
            return true;
        }
        if (validator.isValidName(lastName)){
            request.setAttribute("errorLName",0);
            request.setAttribute("lastName",lastName);
        } else {
            request.setAttribute("errorLName",1);
        }
        return validator.isValidName(lastName);
    }
}
