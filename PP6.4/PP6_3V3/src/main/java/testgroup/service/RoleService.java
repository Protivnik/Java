package testgroup.service;

import testgroup.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    Role getOneRole(Long id);

    List<Role> getAllRole();
}
