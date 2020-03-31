package testgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import testgroup.model.User;
import testgroup.service.RoleService;
import testgroup.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;


    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }


    @GetMapping(value = "/welcome")
    public String welcome (Model model, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user",user);
        return "welcome";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/admin")
    public String admin (Model model){
        List<User> list = userService.getAllUser();
        model.addAttribute("users",list);


        return "admin";
    }

    @GetMapping(value = "/hello")
    public String welcome (){
        return "hello";
    }


}
