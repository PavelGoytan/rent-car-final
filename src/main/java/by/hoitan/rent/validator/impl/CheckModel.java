package by.hoitan.rent.validator.impl;

import by.hoitan.rent.validator.CheckParameter;
import by.hoitan.rent.validator.InputDataValidator;
import jakarta.servlet.http.HttpServletRequest;


public class CheckModel implements CheckParameter {

    private final InputDataValidator validator = InputDataValidator.getInstance();


    @Override
    public boolean execute(HttpServletRequest request) {

        var model = request.getParameter("model");

        if (model == null){
            return true;
        }
        boolean isValid =  validator.isValidModel(model);
        if (isValid) {
            request.setAttribute("errorModel", 0);
            request.setAttribute("model", model);
        } else {
            request.setAttribute("errorModel", 1);

        }
        return isValid;

    }
}
