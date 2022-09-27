package by.hoitan.rent.validator.impl;

import by.hoitan.rent.validator.CheckParameter;
import by.hoitan.rent.validator.InputDataValidator;
import jakarta.servlet.http.HttpServletRequest;

public class CheckRegistrationNumber implements CheckParameter {

    private final InputDataValidator validator = InputDataValidator.getInstance();


    @Override
    public boolean execute(HttpServletRequest request) {
        var registrationNumber = request.getParameter("registration_number");
        if (registrationNumber == null) {
            return true;
        }
        var validRegistrationNumber = validator.isValidRegistrationNumber(registrationNumber);
        if (validRegistrationNumber) {
            request.setAttribute("errorRNumber", 0);
            request.setAttribute("registrationNumber", registrationNumber);
        } else {
            request.setAttribute("errorRNumber", 1);

        }
        return validRegistrationNumber;
    }
}
