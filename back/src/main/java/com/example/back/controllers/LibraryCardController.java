package com.example.back.controllers;


import com.example.back.models.LibraryCard;
import com.example.back.services.LibraryCardService;
import com.example.back.services.LibraryMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class LibraryCardController {
    @Autowired
    LibraryCardService libraryCardService;

    @GetMapping("/libraryCards")
    public ResponseEntity<HashMap<String, Object>> getAllLibraryCard() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All LibraryCardService list");
        resMap.put("data", libraryCardService.getLibraryCard());
        return ResponseEntity.ok(resMap);

    }

    @PostMapping("/libraryCards")
    public ResponseEntity<HashMap<String, Object>> createLibraryCard(@RequestBody LibraryCard libraryCard) {
        LibraryCard createLibraryCard = libraryCardService.createLibraryCard(libraryCard);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All libraryCard list");
        resMap.put("data", createLibraryCard);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/libraryCards/{id}")
    public ResponseEntity<HashMap<String, Object>> updateLibraryCards(@RequestBody LibraryCard libraryCard) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update libraryCards ");
        resMap.put("data", libraryCardService.updateLibraryCard(libraryCard));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/libraryCards/{id}")
    private void deleteLibraryCards(@PathVariable("id") int id) {
        libraryCardService.DeleteLibraryCard(id);
    }

    @GetMapping("/libraryCards/{id}")
    public ResponseEntity<HashMap<String, Object>> findLibraryCardsById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "libraryCards By Id");
        resMap.put("data", libraryCardService.findLibraryCardId(id));
        return ResponseEntity.ok(resMap);
    }
}
