package com.example.back.controllers;

import com.example.back.models.Library;
import com.example.back.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @GetMapping("/libraries")
    public ResponseEntity<HashMap<String, Object>> getAllLibraries() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All libraries list");
        resMap.put("data", libraryService.getLibrary());
        return ResponseEntity.ok(resMap);

    }

    @PostMapping("/libraries")
    public ResponseEntity<HashMap<String, Object>> createLibrary(@RequestBody Library library) {
        Library createLibrary = libraryService.createLibrary(library);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All library list");
        resMap.put("data", createLibrary);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/libraries/{id}")
    public ResponseEntity<HashMap<String, Object>> updateLibrary(@RequestBody Library library) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update libraries ");
        resMap.put("data", libraryService.updateLibrary(library));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/libraries/{id}")
    private void deleteLibrary(@PathVariable("id") int id) {
        libraryService.DeleteLibrary(id);
    }

    @GetMapping("/libraries/{id}")
    public ResponseEntity<HashMap<String, Object>> findLibraryById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "libraryCards By Id");
        resMap.put("data", libraryService.findLibraryId(id));
        return ResponseEntity.ok(resMap);
    }
}
