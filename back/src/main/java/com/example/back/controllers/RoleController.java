package com.example.back.controllers;

import com.example.back.models.Role;
import com.example.back.repository.RoleRepository;
import com.example.back.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class RoleController {
    private RoleRepository roleRepos;
    @Autowired
    RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<HashMap<String, Object>> createRole(@RequestBody Role role) {
        HashMap<String, Object> resMap = new HashMap<>();
        try {
            Role createRole = roleService.roleRegister(role);
            resMap.put("success", true);
            resMap.put("message", "role created successfully");
            resMap.put("data", createRole);
            //return ResponseEntity.created();
            return ResponseEntity.ok(resMap);
        } catch (Exception e) {
            log.error("ERROR: {}", e.getMessage());
            resMap.put("success", false);
            resMap.put("data", null);
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/role")
    public ResponseEntity<HashMap<String, Object>> getRole() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All user list");
        resMap.put("data", roleService.getRoleList());
        return ResponseEntity.ok(resMap);

    }

    @DeleteMapping("/role/{id}")
    private void deleteRole(@PathVariable("id") int id) {
        roleService.DelelteRole(id);
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<HashMap<String, Object>> updateRole(@RequestBody Role role) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "Update Role successfully");
        resMap.put("data", roleService.updateRole(role));
        return ResponseEntity.ok(resMap);
    }

}

