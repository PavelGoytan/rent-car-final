package by.hoitan.rent.controller;

import by.hoitan.rent.command.Command;
import by.hoitan.rent.command.CommandType;
import by.hoitan.rent.command.RequestParameter;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.service.exception.ServiceException;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static by.hoitan.rent.command.RequestParameter.COMMAND;

@WebServlet("/controller")

public class Controller extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }


    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("method process() ");
        var parameter = req.getParameter(COMMAND);
        var command = CommandType.defineCommand(parameter);
        String execute;
        try {
            execute = command.execute(req);

        } catch (DAOException | ServiceException e) {
            LOGGER.error("unknown command: {}", command);
            execute = JspHelper.getPath("error_page");
            resp.sendRedirect(execute);
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher(execute).forward(req, resp);

    }

}
