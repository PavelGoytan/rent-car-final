package by.hoitan.rent.command;

import by.hoitan.rent.command.impl.*;

public enum CommandType {
    GO_TO_HOME_PAGE(new GoToHomePage()),
    SING_IN_PAGE(new GoToSingInPage()),
    REGISTRATION_PAGE(new GoToRegPage()),
    REGISTRATION(new Registration()),
    SING_IN(new SingIn()),
    SING_OUT(new SingOut()),
    CREATE_ORDER(new CreateOrder()),
    GO_TO_CREATE_ORDER(new GoToCreateOrderPage()),
    GO_TO_FIND_ALL_CAR(new GoToFindAllCar()),
    GO_TO_ORDER_CREATED(new GoToOrderCreated()),
    GO_TO_CREATE_CAR_PAGE(new GoToCreateCarPage()),
    CREATE_CAR(new CreateCar()),
    GO_TO_FIND_ALL_USER(new GoToFindAllUser()),
    GO_TO_CHANGE_ROLE(new GoToChangeRole()),
    GO_TO_UPDATE_CAR(new GoToUpdateCar()),
    UPDATE_CAR(new UpdateCar()),
    DELETE_CAR(new DeleteCar()),
    GO_TO_DELETE_CAR(new GoToDeleteCar()),
    CHANGE_ROLE(new ChangeRole()),
    DELETE_USER(new DeleteUser()),
    GO_TO_DELETE_USER(new GoToDeleteUser()),
    GO_TO_FIND_ALL_CAR_BY_LIMIT(new GoToFindAllCarByLimit()),
    FIND_CAR_BY_MODEL(new FindCarByModel()),
    GO_TO_FIND_CAR_BY_MODEL(new GoToFindCarByModel()),
    FIND_USER_BY_ID(new FindUserById()),
    PAY_IS_CORRECT(new GoToPayIsCorrect()),
    GO_TO_FIND_ORDER_BY_USER_ID(new GoToFindOrderByUserId());

    final Command command;

    CommandType(Command command) {
        this.command = command;
    }
    public static Command defineCommand(String commandName){
        return CommandType.valueOf(commandName.toUpperCase()).command;
    }
}
