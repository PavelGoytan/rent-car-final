package by.hoitan.rent.filter;

import by.hoitan.rent.bean.User;
import by.hoitan.rent.util.JspHelper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebFilter("/controller")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(JspHelper.getPath("home"),
            JspHelper.getPath("registration"),
            JspHelper.getPath("sing_in"),
            JspHelper.getPath("go_to_home"));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var httpServletRequest = (HttpServletRequest) request;
        var servletResponse = (HttpServletResponse) response;
        var session = httpServletRequest.getSession();
        var httpSession = ((HttpServletRequest) request).getSession();
        User user = (User) httpSession.getAttribute("user");
        chain.doFilter(request, response);
    }

    private boolean isUserLoggedIn(ServletRequest request) {
        var user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicPath(String requestURI) {
        return PUBLIC_PATH.stream().anyMatch(path -> requestURI.contains(JspHelper.getPath(path)));

    }
}
