package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")

public class blockFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);

        try {
            String role = session.getAttribute("role").toString();
            if (role != null) {
                if (role.equals("user")) {
                    response.sendRedirect(request.getContextPath() + "/user");
                } else if (role.equals("admin")) {
                    chain.doFilter(req, resp);
                }
            }
        }catch (NullPointerException e){
            response.sendRedirect(request.getContextPath() + "/authorization");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
        }

    }
}
