package servlet;

import model.User;
import servise.UserServis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index")
public class mainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> users = new UserServis().getUser();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
