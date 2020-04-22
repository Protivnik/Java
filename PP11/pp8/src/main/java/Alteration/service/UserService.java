package Alteration.service;

import Alteration.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;


public interface UserService extends UserDetailsService {

    List<User> getAllUser();

    void addUser(User user);

    void editUser(User user);

    void editUser(Long id, String firstName, String lastName, int age, String email, String[] rolesString);

    User searchUserFromId(long id);

    User findByUsername(String firstName, String password, String lastName, int age, String email, String[] rolesString);

    void deleteUserFromId(Long id);
}
