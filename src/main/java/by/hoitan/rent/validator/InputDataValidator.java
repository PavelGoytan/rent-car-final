package by.hoitan.rent.validator;

public class InputDataValidator {
    private static final InputDataValidator INSTANCE = new InputDataValidator();
    private  final String MODEL_REGEX = "[a-zA-Z]{2,10} \\S{2,10}";
    private final String REGISTRATION_NUMBER_REGEX = "\\d{4}\\p{Upper}{2}-[1-7]";

    private final String PASSWORD_REGEX = "^[^<>]{5,64}";
    private final String EMPTY = "";
    private final String SPACE = "\\s+";
    private final String NOT_SPACE = "\\S+";

    private static final String NAME_REGEX = "[a-zA-Z]+|[а-яА-ЯёЁ]+";
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+$";

    private static final String PHONE_NUMBER_REGEX = "^[25|44|33|29]\\d{8}";

    private static final String CARD_NUMBER_REGEX = "^\\d{16}$";




    private InputDataValidator() {
    }

    public static InputDataValidator getInstance(){
        return INSTANCE;
    }

    public boolean isValidPassword(String password){
        return !isEmpty(password)&&!haveSpace(password)&&password.matches(PASSWORD_REGEX);
    }

    public boolean isValidName(String name){
        return !isEmpty(name)&&!haveSpace(name)&&name.matches(NAME_REGEX);
    }
    public boolean isValidPhone(String phone){
        return !isEmpty(phone)&&!haveSpace(phone)&&phone.matches(PHONE_NUMBER_REGEX);
    }

    public boolean isValidCard(String card){
        return !isEmpty(card)&&!haveSpace(card)&&card.matches(CARD_NUMBER_REGEX);
    }

    public boolean isValidEmail(String email){
        return !isEmpty(email)&&!haveSpace(email)&&email.matches(EMAIL_REGEX);
    }
    private boolean isEmpty(String  field){
        return field.matches(EMPTY);
    }

    private boolean haveSpace(String field){
        return field.replace(NOT_SPACE, EMPTY).matches(SPACE);
    }


    public boolean isValidRegistrationNumber(String registrationNumber) {
        return !isEmpty(registrationNumber)&&!haveSpace(registrationNumber)
                &&registrationNumber.matches(REGISTRATION_NUMBER_REGEX);
    }

    public boolean isValidModel(String model) {
        return !isEmpty(model)&&model.matches(MODEL_REGEX);
    }
}
