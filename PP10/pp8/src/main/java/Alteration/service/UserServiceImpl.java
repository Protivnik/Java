package Alteration.service;


import Alteration.DAO.UserRepository;
import Alteration.model.Role;
import Alteration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void editUser(User user) {
        if (user.getRoles() == null) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleService.getOneRole(2l));
            user.setRoles(roles);
        }
        if (user.getPassword() == null) {

            user.setPassword(searchUserFromId(user.getId()).getPassword());
        }


        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User searchUserFromId(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByEmail(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s);
    }

    @Override
    public void deleteUserFromId(Long id) {
        userRepository.deleteById(id);
    }
}
