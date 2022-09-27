package by.hoitan.rent.validator;

import by.hoitan.rent.bean.User;

public interface Validator {
    ValidationResult isValid(User user);

}
