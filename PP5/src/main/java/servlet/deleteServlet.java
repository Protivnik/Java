package servlet;

import servise.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (UserService.getUserService().deleteUserFromId(id)) {
            response.sendRedirect(request.getContextPath() + "/admin/admin");
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("removal failed");
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }



}
