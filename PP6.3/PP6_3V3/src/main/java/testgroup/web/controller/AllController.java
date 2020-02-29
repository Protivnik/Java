package testgroup.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import testgroup.model.User;
import testgroup.service.UserService;

import java.util.List;

@Controller
public class AllController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/index")
    public String allUser(ModelMap modelMap) {
        List<User> users = userService.getAllUser();
        modelMap.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "add")
    public String addUserGet() {

        return "add";
    }

    @PostMapping(value = "add")
    public String addUserPost(User user) {
        userService.addUser(user);
        return "redirect:/index";
    }


    @PostMapping(value = "delete")
    public String deleteUser(User user) {

        userService.deleteUser(user);
        return "redirect:/index";
    }

    @GetMapping(value = "edit/{id}")
    public String editUserId(ModelMap modelMap, @PathVariable long id) {
        User user = userService.searchUserFromId(id);
        modelMap.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "edit")
    public String editUserId(User user) {
        userService.editUser(user);
        return "redirect:/index";
    }
}

