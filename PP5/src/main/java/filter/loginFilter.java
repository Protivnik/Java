package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String loginUrl = request.getContextPath() + "/authorization";
        boolean loggedIn = session!=null && session.getAttribute("role") != null ;

        boolean loginRequest = request.getRequestURI().equals(loginUrl);

        if (loggedIn||loginRequest) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(loginUrl);
        }
    }
}
