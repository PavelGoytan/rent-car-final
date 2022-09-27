package by.hoitan.rent.command.impl;


import by.hoitan.rent.bean.User;
import by.hoitan.rent.command.Command;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.dao.impl.SQLUserDAO;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.service.impl.CarServiceImpl;
import by.hoitan.rent.service.impl.ClientServiceImpl;
import by.hoitan.rent.util.JspHelper;
import by.hoitan.rent.validator.InputDataValidator;
import by.hoitan.rent.validator.ParameterRegistration;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Registration implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Registration.class);

    private final SQLUserDAO userDAO = SQLUserDAO.getInstance();

    private final ClientServiceImpl clientService = ClientServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) throws DAOException, ServiceException {

        LOGGER.info("method execute()");

        String path;

        int count = 0;
        for (ParameterRegistration parameter : ParameterRegistration.values()) {
            var par = parameter.toString().toLowerCase();
            var execute = parameter.getParameter().execute(request);
            if (!execute) {
                count++;
            }
        }

        if (count == 0) {
            var user = User.builder().firstName(request.getParameter("first_name"))
                    .lastName(request.getParameter("last_name"))
                    .emailLogin(request.getParameter("email"))
                    .password(request.getParameter("password"))
//                .roleUser(RoleUser.valueOf(request.getParameter("role")))
//                .statusUser(StatusUser.valueOf(request.getParameter("status")))
                    .phoneNumber(request.getParameter("phone"))
                    .build();

            clientService.registration(user);
            path = JspHelper.getPath("sing_in");
            LOGGER.info("user is registered");
        } else {
            LOGGER.info("user is enter wrong parameters");
            path = JspHelper.getPath("registration");
        }


//        if(userDAO.registration(user)){
//             path = JspHelper.getPath("sing_in");
//        } else {
//            path = JspHelper.getPath("registration");
//        }
        return path;

    }
}
