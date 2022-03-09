package com.example.back.controllers;


import com.example.back.models.User;
import com.example.back.repository.UserRepository;
import com.example.back.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepos;
    @Autowired
    UserService userService;
    @PostMapping("/users")
    public ResponseEntity<HashMap<String, Object>> createUser(@RequestBody User user) {
        HashMap<String, Object> resMap = new HashMap<>();
        try {
            User newUser = userRepos.save(user);
            resMap.put("success", true);
            resMap.put("message", "user created successfully");
            resMap.put("data", newUser);
            return ResponseEntity.ok(resMap);
        } catch (Exception e) {
            log.error("ERROR: {}", e.getMessage());
            resMap.put("success", false);
            resMap.put("data", null);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/users")
    public ResponseEntity<HashMap<String, Object>> getStudent() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All user list");
        resMap.put("data", userService.getUserList());
        return ResponseEntity.ok(resMap);

    }

    @DeleteMapping("/users/{id}")
    private void deleteStudent(@PathVariable("id") int id) {
        userService.DelelteUser(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<HashMap<String, Object>> updateUser(@RequestBody User user) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "Update User successfully");
        resMap.put("data", userService.updateUser(user));
        return ResponseEntity.ok(resMap);
    }

}

