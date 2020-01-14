package servise;


import dao.UserDAO;
import model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserServis {

    public boolean addUser(User user) {
        return getUserDAO().addUserDAO(user);
    }

    public ArrayList<User> getUser() {
        return getUserDAO().getUserDAO();
    }

    public boolean deleteUserFromId(int id) {

        return getUserDAO().deleteUserFromIdDAO(id);
    }

    public User searchUserFromId(int id) {
        return getUserDAO().searchUserFromIdDAO(id);
    }

    public boolean editUser(User user) {
        return getUserDAO().editUserDAO(user);
    }

    public static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("mydb?").          //db name
                    append("user=root&").          //login
                    append("password=root").       //password
                    append("&serverTimezone=UTC");   //setup server time

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserDAO getUserDAO() {
        return new UserDAO(getMysqlConnection());
    }
}
