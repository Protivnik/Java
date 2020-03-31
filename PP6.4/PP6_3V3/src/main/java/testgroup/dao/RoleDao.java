package testgroup.dao;

import testgroup.model.Role;

import java.util.List;

public interface RoleDao  {

    void addRole(Role role);


    Role getOneRole(Long id);


    List<Role> getAllRole();

}
