package Alteration.controller;

import Alteration.model.Role;
import Alteration.model.User;
import Alteration.service.RoleService;
import Alteration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<User> list = userService.getAllUser();
        model.addAttribute("users", list);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userA = (User) authentication.getPrincipal();
        model.addAttribute("userA", userA);

        List<Role> roles = roleService.getAllRole();
        model.addAttribute("userAllRoles", roles);

        return "admin";
    }

    @GetMapping(value = "admin/add")
    public String addUserGet(ModelMap modelMap) {
        List<Role> role = roleService.getAllRole();
        modelMap.addAttribute("roles", role);
        return "add";
    }

    @PostMapping(value = "admin/add")
    public String addUserPost(User user, Long... rolesId) {
        Set<Role> roleSet = roleService.getAllRoleId(rolesId);
        user.setRoles(roleSet);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "admin/addRole")
    public String addRole() {

        return "addRole";
    }

    @GetMapping(value = "/admin/deleteRole")
    public String deleteRole(ModelMap modelMap) {
        List<Role> role = roleService.getAllRole();
        modelMap.addAttribute("roles", role);
        return "deleteRole";
    }

    @PostMapping(value = "admin/addRole")
    public String addRolePost(String role) {
        System.out.println(role);
        Role role1 = new Role(role);
        roleService.addRole(role1);
        return "redirect:/admin";
    }


    @PostMapping(value = "admin/delete")
    public String deleteUser(Long id) {
        userService.deleteUserFromId(id);
        return "redirect:/admin";
    }
//    @PostMapping (value = "admin/delete")
//    public String deleteUser(User user) {
//        long idd = user.getId();
//        userService.deleteUserFromId(idd);
//        return "redirect:/admin";
//    }

    @GetMapping(value = "admin/deleteRole/{id}")
    public String deleteRole(@PathVariable Long id) {

        roleService.deleteRole(id);
        return "redirect:/admin";
    }

    @GetMapping(value = "/welcome")
    public String welcome(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "welcome";
    }

//    @GetMapping(value = "admin/edit/{id}")
//    public String editUserId(ModelMap modelMap, @PathVariable long id) {
//        User user = userService.searchUserFromId(id);
//        List<Role> role = roleService.getAllRole();
//
//        modelMap.addAttribute("roles", role);
//        modelMap.addAttribute("user", user);
//
//        return "edit";
//    }

    @PostMapping(value = "admin/edit")
    public String editUserIdPost(User user, Long... rolesId) {

        user.setRoles(roleService.getAllRoleId(rolesId));
        userService.editUser(user);
        return "redirect:/admin";
    }
}
