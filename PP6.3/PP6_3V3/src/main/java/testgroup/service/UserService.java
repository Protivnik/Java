package testgroup.service;

import testgroup.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User searchUserFromId(long id);
}
