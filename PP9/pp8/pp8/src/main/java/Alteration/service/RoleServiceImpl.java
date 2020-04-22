package Alteration.service;

import Alteration.DAO.RoleRepository;
import Alteration.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getOneRole(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Set<Role> getAllRoleId(Long... id) {
        Set<Role> roles = new HashSet<>();
        for (Long l : id) {
            Role role = roleRepository.getOne(l);
            roles.add(role);
        }
        return roles;
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public String getRoleId(long id) {
        return roleRepository.getRoleById(id);
    }
}
