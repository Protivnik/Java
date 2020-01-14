package servlet;

import model.User;
import org.w3c.dom.ls.LSOutput;
import servise.UserServis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet("/add")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean sex = Integer.parseInt(request.getParameter("sex")) == 1;
        User user = new User(name, email, age, sex);
        if (new UserServis().addUser(user)) {
            response.sendRedirect(request.getContextPath() + "/index");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
