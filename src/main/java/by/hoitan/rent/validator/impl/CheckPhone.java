package by.hoitan.rent.validator.impl;

import by.hoitan.rent.validator.CheckParameter;
import by.hoitan.rent.validator.InputDataValidator;
import jakarta.servlet.http.HttpServletRequest;

public class CheckPhone implements CheckParameter {

    private final InputDataValidator validator = InputDataValidator.getInstance();

    @Override
    public boolean execute(HttpServletRequest request) {
        var phone = request.getParameter("phone");
        if (phone == null) {
            return true;
        } else if (validator.isValidPhone(phone)) {
            request.setAttribute("errorPhone", 0);
            request.setAttribute("phone", phone);
        } else {
            request.setAttribute("errorPhone", 1);
        }
        return validator.isValidPhone(phone);
    }
}
