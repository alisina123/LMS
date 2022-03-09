package com.example.back.controllers;

import com.example.back.models.Book;
import com.example.back.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<HashMap<String, Object>> getAllBooks() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All books list");
        resMap.put("data", bookService.getBook());
        return ResponseEntity.ok(resMap);

    }

    @PostMapping("/books")
    public ResponseEntity<HashMap<String, Object>> createBook(@RequestBody Book book) {
        Book createBook = bookService.createLBook(book);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All books list");
        resMap.put("data", createBook);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<HashMap<String, Object>> updateBook(@RequestBody Book book) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update books ");
        resMap.put("data", bookService.updateBook(book));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/books/{id}")
    private void deleteBook(@PathVariable("id") int id) {
        bookService.DeleteBook(id);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<HashMap<String, Object>> findBookById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "books By Id");
        resMap.put("data", bookService.findBookId(id));
        return ResponseEntity.ok(resMap);
    }
}
