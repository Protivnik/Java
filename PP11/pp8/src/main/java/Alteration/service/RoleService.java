package Alteration.service;

import Alteration.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface RoleService {


    Role getOneRole(Long id);

    List<Role> getAllRole();
    String getRoleId (long id);

    Set<Role> getAllRoleId(Long ... id);


    Role getRoleName(String name);
}