package com.example.back.services;

import com.example.back.models.BookCategory;
import com.example.back.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryService {
    @Autowired
    BookCategoryRepository bookCategoryRepository;

    public BookCategory createLBookCategory(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    public List<BookCategory> getBookCategory() {
        return bookCategoryRepository.findAll();
    }

    public void DeleteBookCategory(int id) {
        bookCategoryRepository.deleteById(id);
    }

    public BookCategory updateBookCategory(BookCategory bookCategory) {
        int bookCategoryId = bookCategory.getId();
        try {
            BookCategory updateBookCategory = bookCategoryRepository.findBookCategoryById(bookCategoryId);
            if (updateBookCategory != null) {
                updateBookCategory = bookCategory;
                return bookCategoryRepository.save(bookCategory);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BookCategory findBookCategoryId(int bookCategoryId) {
        try {
            return bookCategoryRepository.getById(bookCategoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
