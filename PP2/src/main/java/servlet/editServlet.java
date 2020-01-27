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

@WebServlet("/edit")
public class editServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        User useredit = null;
        if (name == null) {
            User user = new UserServis().searchUserFromId(id);
            request.setAttribute("user", user);
//            response.sendRedirect(request.getContextPath() + "/edit.jsp");
            getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
        }else {
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            boolean sex = Integer.parseInt(request.getParameter("sex")) == 1;

            useredit = new User(id, name, email, age, sex);}


        if ((useredit!=null)&&new UserServis().editUser(useredit)) {
            response.sendRedirect(request.getContextPath() + "/index");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        } else {
            response.getWriter().println("Обнавление не удалось");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }




    }

}
