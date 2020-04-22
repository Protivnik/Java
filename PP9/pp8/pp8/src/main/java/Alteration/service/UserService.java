package Alteration.service;

import Alteration.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService  extends UserDetailsService {
    List<User> getAllUser();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User searchUserFromId(long id);

    User findByUsername (String name);

    void deleteUserFromId(Long id);
}
