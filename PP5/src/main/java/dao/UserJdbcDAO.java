package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    private Connection connection;

    private ArrayList<User> getList(ResultSet resultSet) throws SQLException {
        ArrayList<User> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String pass = resultSet.getString("password");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            String role = resultSet.getString("role");
            boolean sex = resultSet.getBoolean("sex");
            list.add(new User(id, name, pass, email, age, role, sex));
        }
        return list;
    }

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<User> getUserDAO() {
        ArrayList<User> list = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM user")) {
            list = getList(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public boolean addUserDAO(User user) {
        try (Statement statement = connection.createStatement()) {
            String string = "INSERT into user ( name,email,age,password,role,sex) VALUES ('" + user.getName() + "','" + user.getEmail()
                    + "','" + user.getAge() + "','" + user.getPassword() + "','" + user.getRole() + "'," + user.isSex() + ")";
            statement.execute(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteUserFromIdDAO(int id) {
        try (Statement statement = connection.createStatement()) {
            String delete = "DELETE  from user where id=" + id;
            statement.executeUpdate(delete);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public User searchUserFromIdDAO(int id) {
        String search = "select * from user where id='" + id + "'";
        User user = null;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(search);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String pass = resultSet.getString("password");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                String role = resultSet.getString("role");
                boolean sex = resultSet.getBoolean("sex");

                user = new User(id, name, pass, email, age, role, sex);
                resultSet.close();
                return user;
            }
        } catch (SQLException e) {
            return user;
        }
        return user;
    }

    public boolean editUserDAO(User user) {
        try (Statement statement = connection.createStatement()) {

            String update = "UPDATE user set name='" + user.getName() + "',email = '" + user.getEmail()
                    + "',age ='" + user.getAge() + "',password ='" + user.getPassword() + "',role ='" + user.getRole() + "',sex = " + user.isSex() + " where id='" + user.getId() + "'";

            statement.executeUpdate(update);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public String RoleInUserDAO(String name, String password) {
        String roleBack = null;
        ArrayList<User> list = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM user where name=" + name)) {
            list = getList(resultSet);
            for (User user : list) {
                if (password.equals(user.getPassword())) {
                    roleBack = user.getRole();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleBack;
    }

}

