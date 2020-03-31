package testgroup.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import testgroup.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User searchUserFromId(long id);

    User findByUsername (String name);
}
