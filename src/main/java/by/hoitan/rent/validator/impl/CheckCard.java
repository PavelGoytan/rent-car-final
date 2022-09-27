package by.hoitan.rent.validator.impl;

import by.hoitan.rent.validator.CheckParameter;
import by.hoitan.rent.validator.InputDataValidator;
import jakarta.servlet.http.HttpServletRequest;

public class CheckCard implements CheckParameter {

    private final InputDataValidator validator = InputDataValidator.getInstance();

    @Override
    public boolean execute(HttpServletRequest request) {
        var cardNumber = request.getParameter("card_number");
        if (cardNumber==null){
            return true;
        }
        if (validator.isValidCard(cardNumber)){
            request.setAttribute("errorCNumber",0);
            request.setAttribute("cardNumber",cardNumber);
        } else {
            request.setAttribute("errorCNumber",1);
        }
        return validator.isValidCard(cardNumber);
    }
}
