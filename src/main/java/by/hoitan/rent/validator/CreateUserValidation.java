package by.hoitan.rent.validator;

import by.hoitan.rent.bean.User;

public class CreateUserValidation implements Validator {

    @Override
    public ValidationResult isValid(User user) {
        ValidationResult validationResult = new ValidationResult();
        if(user.getLastName()==null){
            validationResult.add(new Error("invalid.firstName", "firstName is invalid"));
        }
        return validationResult;
    }
}
