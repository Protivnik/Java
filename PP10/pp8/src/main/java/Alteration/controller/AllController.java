package Alteration.controller;

import Alteration.model.Role;
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

import java.util.List;

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
//        List<User> list = userService.getAllUser();
//        model.addAttribute("users", list);
//
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userA = (User) authentication.getPrincipal();
        model.addAttribute("userA", userA);
//
//        List<Role> roles = roleService.getAllRole();
//        model.addAttribute("userAllRoles", roles);

        return "admin";
    }


//    @PostMapping(value = "admin/add")
//    public String addUserPost(User user, Long... rolesId) {
//        Set<Role> roleSet = roleService.getAllRoleId(rolesId);
//
//        user.setRoles(roleSet);
//        userService.addUser(user);
//        return "redirect:/admin";
//    }

//    @GetMapping(value = "admin/addRole")
//    public String addRole() {
//
//        return "addRole";
//    }
//
//
//    @GetMapping(value = "/admin/deleteRole")
//    public String deleteRole(ModelMap modelMap) {
//        List<Role> role = roleService.getAllRole();
//        modelMap.addAttribute("roles", role);
//        return "deleteRole";
//    }
//
//    @PostMapping(value = "admin/addRole")
//    public String addRolePost(String role) {
//        System.out.println(role);
//        Role role1 = new Role(role);
//        roleService.addRole(role1);
//        return "redirect:/admin";
//    }

//    @GetMapping(value = "admin/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        userService.deleteUserFromId(id);
//        return "redirect:/index";
//    }


//    @GetMapping(value = "admin/deleteRole/{id}")
//    public String deleteRole(@PathVariable Long id) {
//
//        roleService.deleteRole(id);
//        return "redirect:/admin";
//    }

    @GetMapping(value = "/welcome")
    public String welcome(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "welcome";
    }


//    @PostMapping(value = "admin/edit")
////    public String editUserIdPost(User user, Long... rolesId) {
//    public String editUserIdPost(Long id,String firstName,String lastName,int age,String email,String[ ] roles) {
//
//        Set<Role> roleSet =new HashSet<>();
//        for (String role:roles){
//            roleSet.add(roleService.getRoleName(role));
//        }
//        User user = new User(id,firstName,lastName,email,age);
//        user.setRoles(roleSet);
//        userService.editUser(user);
//        return "redirect:/admin";

//        if (rolesId==null){
//            roleSet.add(roleService.getOneRole(1l));
//        }else {
//            roleSet= roleService.getAllRoleId(rolesId);
//        }

//        user.setRoles(roleSet);
//        userService.editUser(user);
//        return "redirect:/admin";

//        user.setRoles(roleService.getAllRoleId(rolesId));
//        userService.editUser(user);
//        return "redirect:/admin";
//    }

}
