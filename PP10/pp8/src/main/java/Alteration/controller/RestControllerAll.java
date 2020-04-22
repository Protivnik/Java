package Alteration.controller;

import Alteration.model.Role;
import Alteration.model.User;
import Alteration.service.RoleService;
import Alteration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class RestControllerAll {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    //    @PreAuthorize("hasRole('ADMIN')")

    @GetMapping(value = "/admin/rest/user")
    public List<User> adminUser() {
        return userService.getAllUser();
    }

    @GetMapping(value = "/admin/rest/role")
    public List<Role> adminRole() {
        return roleService.getAllRole();
    }

    @GetMapping(value = "admin/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUserFromId(id);
    }

    @PostMapping(value = "admin/edit")
//    public String editUserIdPost(User user, Long... rolesId) {
    public void editUserIdPost(Long id, String firstName, String lastName, int age, String email, String[] rolesString) {

        Set<Role> roleSet = new HashSet<>();
        for (String role : rolesString) {
            roleSet.add(roleService.getRoleName(role));
        }
        User user = new User(id, firstName, lastName, email, age);
        user.setRoles(roleSet);
        userService.editUser(user);
    }

    @PostMapping(value = "admin/add")
    public User addUserPost(String firstName, String password, String lastName, int age, String email, String[] rolesString) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : rolesString) {
            roleSet.add(roleService.getRoleName(role));
        }
        User user = new User(firstName, lastName, email, password, age);
        user.setRoles(roleSet);
        userService.addUser(user);
        return userService.findByUsername(email);
    }
}