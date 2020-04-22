package Alteration.service;

//import Alteration.DAO.RoleRepository;
import Alteration.config.ConnectionServer;
import Alteration.model.Role;
import Alteration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {


    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers= new ConnectionServer().createHttpHeaders();


    @Override
    public Role getOneRole(Long id) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Role role = restTemplate.exchange(
                "http://localhost:8081/adminS/rest/roles/"+id, HttpMethod.GET, entity, Role.class).getBody();

        return role;
    }


    public List<Role> getAllRole() {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Role[]> response = restTemplate.exchange(
                "http://localhost:8081/adminS/rest/roles", HttpMethod.GET, entity, Role[].class);

        return Arrays.asList(response.getBody());
    }

    @Override
    public Set<Role> getAllRoleId(Long... id) {
        Set<Role> roles = new HashSet<>();
        for (Long l : id) {
            Role role = getOneRole(l);
            roles.add(role);
        }
        return roles;
    }

    @Override
    public String getRoleId(long id) {
        return getOneRole(id).toString();
    }

    @Override
    public Role getRoleName(String name) {
        List<Role> roleList = getAllRole();
        Role roles = null;
        for (Role roleS : roleList) {
            if (roleS.toString().equals(name)) {
                roles = roleS;
            }
        }
        return roles;
    }
}
