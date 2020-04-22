package javamentrPP.server.controller;

import javamentrPP.server.DAO.RoleRepository;
import javamentrPP.server.DAO.UserRepository;
import javamentrPP.server.model.Role;
import javamentrPP.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerRest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping(value = "adminS/rest/user")
    public List<User> getRestUser() {
        return userRepository.findAll();
    }

    @GetMapping(value = "adminS/delete/{id}")
    public void delete(@PathVariable Long id) {

        userRepository.delete(userRepository.getOne(id));

    }

    @PostMapping(value = "adminS/edit/")
    public void edit(@RequestBody User user) {

        userRepository.save(user);
    }

    @GetMapping (value = "adminS/edit/{id}")
    public User edit(@PathVariable Long id) {

        return userRepository.findById(id).get();
    }

    @PostMapping(value = "adminS/add/")
    private void add(@RequestBody User user) {

        userRepository.save(user);
    }

    @PostMapping(value = "adminS/rest/userName/")
    public User getUserFoId(@RequestBody String s) {

        return userRepository.findByEmail(s);
    }

    @GetMapping(value = "adminS/rest/roles")
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    @GetMapping(value = "adminS/rest/roles/{id}")
    public Role getRoleForId(@PathVariable Long id){
        return roleRepository.findById(id).get();
    }


}
