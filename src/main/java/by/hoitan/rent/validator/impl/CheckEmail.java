package by.hoitan.rent.validator.impl;

import by.hoitan.rent.validator.CheckParameter;
import by.hoitan.rent.validator.InputDataValidator;
import jakarta.servlet.http.HttpServletRequest;

public class CheckEmail implements CheckParameter {

    private final InputDataValidator validator = InputDataValidator.getInstance();


    @Override
    public boolean execute(HttpServletRequest request) {
        var email = request.getParameter("email");
        if (email == null) {
            return true;
        } else if (validator.isValidEmail(email)) {
            request.setAttribute("errorEmail", 0);
            request.setAttribute("email", email);
        } else {
            request.setAttribute("errorEmail", 1);
        }
        return validator.isValidEmail(email);
    }
}
