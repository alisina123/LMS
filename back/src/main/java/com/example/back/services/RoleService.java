package com.example.back.services;

import com.example.back.models.Role;
import com.example.back.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepos;

    public Role roleRegister(Role role) {
        return roleRepos.save(role);

    }

    public List<Role> getRoleList() {
        try {

            return roleRepos.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Role updateRole(Role role) {
        int roleId = role.getId();
        try {
            Role updateRole = roleRepos.findRoleById(roleId);
            if (updateRole != null) {
                updateRole = role;
                return roleRepos.save(role);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void DelelteRole(int roleId) {
        roleRepos.deleteById(roleId);
    }
}
