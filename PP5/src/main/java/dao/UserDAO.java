package dao;

import model.User;

import java.util.ArrayList;

public interface UserDAO {

    boolean addUserDAO(User user);

    ArrayList<User> getUserDAO();

    boolean deleteUserFromIdDAO(int id);

    User searchUserFromIdDAO(int id);

    boolean editUserDAO(User user);

    String RoleInUserDAO(String name,String password);
}
