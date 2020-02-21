package servlet;

import model.User;
import servise.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String role = request.getParameter("role");
        boolean sex = Integer.parseInt(request.getParameter("sex")) == 1;
        User user = new User(name,pass, email, age, role, sex);



        if (UserService.getUserService().addUser(user)) {
            response.sendRedirect(request.getContextPath() + "/admin/admin");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
