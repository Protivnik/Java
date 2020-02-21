package servlet;

import model.User;
import servise.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/authorization")
public class authServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();

        String role = UserService.getUserService().userInRole(name,pass);
        session.setAttribute("role",role);
        try {
            if (role.equals("user")) {
                response.sendRedirect(request.getContextPath() + "/user");
            } else if (role.equals("admin")) {
                response.sendRedirect(request.getContextPath() + "/admin/admin");
            }
        } catch (NullPointerException e) {
            getServletContext().getRequestDispatcher("/authorization.jsp").forward(request, response);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(request, response);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }
}
