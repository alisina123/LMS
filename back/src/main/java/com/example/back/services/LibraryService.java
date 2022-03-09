package com.example.back.services;

import com.example.back.models.Library;
import com.example.back.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    LibraryRepository libraryRepository;

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public List<Library> getLibrary() {
        return libraryRepository.findAll();
    }

    public void DeleteLibrary(int id) {
        libraryRepository.deleteById(id);
    }

    public Library updateLibrary(Library library) {
        int libraryId = library.getId();
        try {
            Library updateLibrary = libraryRepository.findLibraryById(libraryId);
            if (updateLibrary != null) {
                updateLibrary = library;
                return libraryRepository.save(library);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Library findLibraryId(int libraryId) {
        try {
            return libraryRepository.findLibraryById(libraryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
