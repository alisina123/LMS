package com.example.back.controllers;

import com.example.back.models.BookCategory;
import com.example.back.services.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

public class BookCategoryController {
    @Autowired
    BookCategoryService bookCategoryService;

    @GetMapping("/bookCategories")
    public ResponseEntity<HashMap<String, Object>> getAllBookCategory() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All bookCategories list");
        resMap.put("data", bookCategoryService);
        return ResponseEntity.ok(resMap);

    }

    @PostMapping("/bookCategories")
    public ResponseEntity<HashMap<String, Object>> createBookCategories(@RequestBody BookCategory bookCategory) {
        BookCategory createLibraryMembers = bookCategoryService.createLBookCategory(bookCategory);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All bookCategories list");
        resMap.put("data", createLibraryMembers);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/bookCategories/{id}")
    public ResponseEntity<HashMap<String, Object>> updateBookCategories(@RequestBody BookCategory bookCategory) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update bookCategories ");
        resMap.put("data", bookCategoryService.updateBookCategory(bookCategory));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/bookCategories/{id}")
    private void deleteLibraryMembers(@PathVariable("id") int id) {
        bookCategoryService.DeleteBookCategory(id);
    }

    @GetMapping("/bookCategories/{id}")
    public ResponseEntity<HashMap<String, Object>> findBookCategoriesById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "bookCategories By Id");
        resMap.put("data", bookCategoryService.findBookCategoryId(id));
        return ResponseEntity.ok(resMap);
    }
}
