package com.example.back.services;

import com.example.back.models.Book;
import com.example.back.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book createLBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    public void DeleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {
        int bookId = book.getId();
        try {
            Book updateBook = bookRepository.findBookById(bookId);
            if (updateBook != null) {
                updateBook = book;
                return bookRepository.save(book);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book findBookId(int bookId) {
        try {
            return bookRepository.getById(bookId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
