package servlet;

import model.User;
import servise.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit")
public class editServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        User useredit = null;
        if (name == null) {
            User user = UserService.getUserService().searchUserFromId(id);
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
        }else {
            String pass = request.getParameter("password");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            String role = request.getParameter("role");
            boolean sex = Integer.parseInt(request.getParameter("sex")) == 1;

            useredit = new User(id, name, pass, email, age, role, sex);
        }


        if ((useredit!=null)&&UserService.getUserService().editUser(useredit)) {
            response.sendRedirect(request.getContextPath() + "/admin/admin");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        } else {
            response.getWriter().println("Обнавление не удалось");
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }




    }

}
