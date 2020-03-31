package testgroup.dao;


import testgroup.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User searchUserFromId(long id);

    User findByUserName(String name);
}
