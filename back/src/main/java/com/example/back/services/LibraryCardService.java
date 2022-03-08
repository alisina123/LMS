package com.example.back.services;

import com.example.back.models.LibraryCard;
import com.example.back.repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryCardService {
    @Autowired
    LibraryCardRepository libraryCardRepository;

    public LibraryCard createLibraryCard(LibraryCard libraryCard) {
        return libraryCardRepository.save(libraryCard);
    }

    public List<LibraryCard> getLibraryCard() {
        return libraryCardRepository.findAll();
    }

    public void DeleteLibraryCard(int id) {
        libraryCardRepository.deleteById(id);
    }

    public LibraryCard updateLibraryCard(LibraryCard libraryCard) {
        int libraryCardId = libraryCard.getId();
        try {
            LibraryCard updateLibraryCard = libraryCardRepository.findLibraryCardById(libraryCardId);
            if (updateLibraryCard != null) {
                updateLibraryCard = libraryCard;
                return libraryCardRepository.save(libraryCard);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public LibraryCard findLibraryCardId(int libraryCardId) {
        try {
            return libraryCardRepository.getById(libraryCardId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
