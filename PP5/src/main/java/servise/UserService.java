package servise;

import dao.UserDAO;
import util.userDaoFactory;
import model.User;

import java.util.ArrayList;

public class UserService {
    private  static UserService userService ;
    private final UserDAO userDAO =new userDaoFactory().getDAO();

    private UserService() {
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public boolean addUser(User user) {
        return userDAO.addUserDAO(user);
    }

    public ArrayList<User> getUser() {
        return userDAO.getUserDAO();
    }

    public boolean deleteUserFromId(int id) {
        return userDAO.deleteUserFromIdDAO(id);
    }

    public User searchUserFromId(int id) {
        return userDAO.searchUserFromIdDAO(id);
    }

    public boolean editUser(User user) {
        return userDAO.editUserDAO(user);
    }

    public String userInRole(String name,String password){
        return userDAO.RoleInUserDAO(name,password);
    }
}
