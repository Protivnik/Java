package Alteration.controller;

import Alteration.model.User;
import Alteration.service.RoleService;
import Alteration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AllController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String loginPage() {

//        Role roleA= new Role("ADMIN");
//        roleService.addRole(roleA);
//        Role roleU= new Role("USER");
//    roleService.addRole(roleU);
//
//        Set<Role> roles= new HashSet<>();
//        roles.add(roleService.getOneRole(1l));
//        roles.add(roleService.getOneRole(2l));
//        User user = new User("Admin","Admin","Admin@mail.ru","Admin",23);
//        user.setRoles(roles);
//        userService.addUser(user);

        return "login";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/admin")
    public String admin(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userA = (User) authentication.getPrincipal();
        model.addAttribute("userA", userA);


        return "admin";
    }

    @GetMapping(value = "/welcome")
    public String welcome(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "welcome";
    }


}
