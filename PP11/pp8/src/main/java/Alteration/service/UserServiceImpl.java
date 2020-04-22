package Alteration.service;


//import Alteration.DAO.UserRepository;

import Alteration.config.ConnectionServer;
import Alteration.model.Role;
import Alteration.model.User;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new ConnectionServer().createHttpHeaders();


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleService roleService;

    private Set<Role> getRoleSet(String [] rolesString){
        Set<Role> roleSet = new HashSet<>();
        for (String role : rolesString){
            roleSet.add(roleService.getRoleName(role));
        }
        return roleSet;
    }




    @Override
    public List<User> getAllUser() {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<User[]> response = restTemplate.exchange("http://localhost:8081/adminS/rest/user", HttpMethod.GET, entity, User[].class);
        List<User> users = Arrays.asList(response.getBody());
        return users;
    }

    @Override
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        String url = "http://localhost:8081/adminS/add/";
        restTemplate.postForObject(url, entity, String.class);
    }

    @Override
    public void editUser(Long id, String firstName, String lastName, int age, String email, String[] rolesString) {
        
        User user = new User(id, firstName, lastName, email, age);
        user.setRoles(getRoleSet(rolesString));
        editUser(user);
    }

    @Override
    public void editUser(User user) {

        if (user.getPassword() == null) {
            User user1 = searchUserFromId(user.getId());
            user.setPassword(user1.getPassword());
        }

        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        String url = "http://localhost:8081/adminS/edit/";
        restTemplate.postForObject(url, entity, String.class);
    }


    @Override
    public User searchUserFromId(long id) {

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<User> user = restTemplate.exchange("http://localhost:8081/adminS/edit/" + id, HttpMethod.GET, entity, User.class);
        return user.getBody();

    }

    @Override
    public User findByUsername(String firstName, String password, String lastName, int age, String email, String[] rolesString) {

        User user = new User(firstName, lastName, email, password, age);
        user.setRoles(getRoleSet(rolesString));
        addUser(user);

        return (User) loadUserByUsername(email);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String theUrl = "http://localhost:8081/adminS/rest/userName/";

        HttpEntity<String> entity = new HttpEntity<>(s, headers);
        User user = restTemplate.postForObject(theUrl, entity, User.class);
        return user;
    }

    @Override
    public void deleteUserFromId(Long id) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        restTemplate.exchange("http://localhost:8081/adminS/delete/" + id, HttpMethod.GET, entity, String.class);
    }
}
