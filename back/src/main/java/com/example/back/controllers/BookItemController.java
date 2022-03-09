package com.example.back.controllers;

import com.example.back.models.BookItem;
import com.example.back.services.BookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class BookItemController {
    @Autowired
    BookItemService bookItemService;

    @GetMapping("/bookItems")
    public ResponseEntity<HashMap<String, Object>> getAllBookItems() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All bookItems list");
        resMap.put("data", bookItemService.getBookItem());
        return ResponseEntity.ok(resMap);

    }

    @PostMapping("/bookItems")
    public ResponseEntity<HashMap<String, Object>> createBookItem(@RequestBody BookItem bookItem) {
        BookItem createBookItem = bookItemService.createBookItem(bookItem);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All bookItem list");
        resMap.put("data", createBookItem);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/bookItems/{id}")
    public ResponseEntity<HashMap<String, Object>> updateBookItem(@RequestBody BookItem bookItem) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update bookItem ");
        resMap.put("data", bookItemService.updateBookItem(bookItem));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/bookItems/{id}")
    private void deleteBookItem(@PathVariable("id") int id) {
        bookItemService.DeleteBookItem(id);
    }

    @GetMapping("/bookItems/{id}")
    public ResponseEntity<HashMap<String, Object>> findBookItemsById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "bookItems By Id");
        resMap.put("data", bookItemService.findBookItemId(id));
        return ResponseEntity.ok(resMap);
    }
}
