package com.example.back.controllers;


import com.example.back.models.Permission;
import com.example.back.services.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping("/api")
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @PostMapping("/permissions")
    public ResponseEntity<HashMap<String, Object>> createPermission(@RequestBody Permission permission) {
        HashMap<String, Object> resMap = new HashMap<>();
        try {
            Permission newPermission = permissionService.permissionRegister(permission);
            resMap.put("success", true);
            resMap.put("message", "permission created successfully");
            resMap.put("data", newPermission);
            //return ResponseEntity.created();
            return ResponseEntity.ok(resMap);
        } catch (Exception e){
            log.error("ERROR: {}", e.getMessage());
            resMap.put("success", false);
            resMap.put("data", null);
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/permissions")
    public ResponseEntity<HashMap<String, Object>> getPermission()
    {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All permission list");
        resMap.put("data", permissionService.getPermissionList());
        return ResponseEntity.ok(resMap);

    }
    @DeleteMapping("/permissions/{id}")
    private void deletePermission(@PathVariable("id") int id) {
        permissionService.DeleltePermission(id);
    }
    @PutMapping("/permissions/{id}")
    public ResponseEntity<HashMap<String, Object>> updatePermission(@RequestBody Permission permission)
    {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "Update Permission successfully");
        resMap.put("data", permissionService.updatePermission(permission));
        return ResponseEntity.ok(resMap);
    }
}
