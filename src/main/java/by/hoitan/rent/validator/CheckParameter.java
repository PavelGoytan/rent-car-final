package by.hoitan.rent.validator;

import jakarta.servlet.http.HttpServletRequest;

public interface CheckParameter {
    boolean execute(HttpServletRequest request);
}
