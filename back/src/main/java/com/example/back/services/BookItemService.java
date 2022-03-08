package com.example.back.services;

import com.example.back.models.BookItem;
import com.example.back.repository.BookItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookItemService {
    @Autowired
    BookItemRepository bookItemRepository;

    public BookItem createBookItem(BookItem bookItem) {
        return bookItemRepository.save(bookItem);
    }

    public List<BookItem> getBookItem() {
        return bookItemRepository.findAll();
    }

    public void DeleteBookItem(int id) {
        bookItemRepository.deleteById(id);
    }

    public BookItem updateBookItem(BookItem bookItem) {
        int bookItemId = bookItem.getId();
        try {
            BookItem updateBookItem = bookItemRepository.findBookItemById(bookItemId);
            if (updateBookItem != null) {
                updateBookItem = bookItem;
                return bookItemRepository.save(bookItem);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BookItem findBookItemId(int bookItemId) {
        try {
            return bookItemRepository.getById(bookItemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
