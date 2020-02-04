package servlet;

import servise.UserServis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (new UserServis().deleteUserFromId(id)) {
            response.sendRedirect(request.getContextPath() + "/index");
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("removal failed");
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }



}
