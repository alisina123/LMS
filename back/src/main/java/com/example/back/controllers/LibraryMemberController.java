package com.example.back.controllers;


import com.example.back.models.LibraryMember;
import com.example.back.services.LibraryMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class LibraryMemberController {
    @Autowired
    LibraryMemberService libraryMemberService;

    @GetMapping("/libraryMembers")
    public ResponseEntity<HashMap<String, Object>> getAllLibraryMembers() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All LibraryMembers list");
        resMap.put("data", libraryMemberService.getLibraryMember());
        return ResponseEntity.ok(resMap);

    }

    @PostMapping("/libraryMembers")
    public ResponseEntity<HashMap<String, Object>> createLibraryMembers(@RequestBody LibraryMember libraryMember) {
        LibraryMember createLibraryMembers = libraryMemberService.createLibraryMember(libraryMember);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All libraryMember list");
        resMap.put("data", createLibraryMembers);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/libraryMembers/{id}")
    public ResponseEntity<HashMap<String, Object>> updateLibraryMembers(@RequestBody LibraryMember libraryMember) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update libraryMember ");
        resMap.put("data", libraryMemberService.updateLibraryMember(libraryMember));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/libraryMembers/{id}")
    private void deleteLibraryMembers(@PathVariable("id") int id) {
        libraryMemberService.DeleteLibraryMember(id);
    }

    @GetMapping("/libraryMembers/{id}")
    public ResponseEntity<HashMap<String, Object>> findLibraryMembersById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "LibraryMembers By Id");
        resMap.put("data", libraryMemberService.findLibraryMemberId(id));
        return ResponseEntity.ok(resMap);
    }
}
