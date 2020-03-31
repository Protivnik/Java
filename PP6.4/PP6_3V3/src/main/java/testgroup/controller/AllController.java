package testgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import testgroup.model.Role;
import testgroup.model.User;
import testgroup.service.RoleService;
import testgroup.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AllController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


//    @GetMapping(value = "/index")
//    public String allUser(ModelMap modelMap) {
//        List<User> users = userService.getAllUser();
//        modelMap.addAttribute("users", users);
//        return "index";
//    }

    @GetMapping(value = "admin/add")
    public String addUserGet(ModelMap modelMap) {
        List<Role> role = roleService.getAllRole();
        modelMap.addAttribute("roles", role);
        return "add";
    }

    @PostMapping(value = "admin/add")
    public String addUserPost(User user, Long ... news) {
        Set<Role> roles = new HashSet<>();

        for (Long aa :news){
            roles.add(roleService.getOneRole(aa));
        }
        user.setRoles(roles);
        userService.addUser(user);
        return "redirect:/admin";
    }


    @PostMapping(value = "delete")
    public String deleteUser(Long id) {
        User user = userService.searchUserFromId(id);
        userService.deleteUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "admin/edit/{id}")
    public String editUserId(ModelMap modelMap, @PathVariable long id) {
        User user = userService.searchUserFromId(id);

        List<Role> role = roleService.getAllRole();
        modelMap.addAttribute("roles", role);

        modelMap.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "admin/edit")
    public String editUserId(User user,Long ... news) {
        Set<Role> roles = new HashSet<>();
        for (Long aa :news){
            roles.add(roleService.getOneRole(aa));
        }
        user.setRoles(roles);

        userService.editUser(user);
        return "redirect:/admin";
    }
    @GetMapping(value = "admin/addRole")
    public String addRole() {

        return "addRole";
    }

    @PostMapping(value = "admin/addRole")
    public String addRolePost(Role role){
        roleService.addRole(role);
        return "redirect:/admin";
    }

}

