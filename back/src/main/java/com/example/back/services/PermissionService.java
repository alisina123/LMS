package com.example.back.services;

import com.example.back.models.Permission;
import com.example.back.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionRepository permissionRepository;
    public Permission permissionRegister(Permission permission)
    {
        return permissionRepository.save(permission);

    }
    public List<Permission> getPermissionList()
    {
        try {

            return permissionRepository.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public Permission updatePermission(Permission permission) {
        int permissionId =  permission.getId();
        try {
            Permission updatePermission = permissionRepository.findPermissionById(permissionId);
            if (updatePermission != null) {
                updatePermission = permission;
                return permissionRepository.save(permission);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void DeleltePermission(int permissionId)
    {
        permissionRepository.deleteById(permissionId);
    }
}
