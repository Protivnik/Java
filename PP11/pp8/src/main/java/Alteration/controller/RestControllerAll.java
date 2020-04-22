package Alteration.controller;

import Alteration.model.Role;
import Alteration.model.User;
import Alteration.service.RoleService;
import Alteration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class RestControllerAll {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

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

    public void editUserIdPost(Long id, String firstName, String lastName, int age, String email, String[] rolesString) {

        userService.editUser(id, firstName, lastName, age, email, rolesString);
    }

    @PostMapping(value = "admin/add")
    public User addUserPost(String firstName, String password, String lastName, int age, String email, String[] rolesString) {

        return userService.findByUsername(firstName, password, lastName, age, email, rolesString);
    }
}