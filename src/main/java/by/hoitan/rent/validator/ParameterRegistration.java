package by.hoitan.rent.validator;

import by.hoitan.rent.validator.impl.*;

public enum ParameterRegistration {
    FIRST_NAME(new CheckFirstName()),
    LAST_NAME(new CheckLastName()),
    PASSWORD(new CheckPassword()),
    EMAIL(new CheckEmail()),
    PHONE(new CheckPhone()),
    CARD_NUMBER(new CheckCard()),
    REGISTRATION_NUMBER(new CheckRegistrationNumber()),
    MODEL(new CheckModel());

    final CheckParameter parameter;

    ParameterRegistration(CheckParameter parameter) {
        this.parameter = parameter;
    }

    public static CheckParameter defineParameter(String parameter){
        return ParameterRegistration.valueOf(parameter.toUpperCase()).parameter;
    }

    public CheckParameter getParameter() {
        return parameter;
    }
}
