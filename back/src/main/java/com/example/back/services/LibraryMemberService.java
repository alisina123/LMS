package com.example.back.services;

import com.example.back.models.LibraryMember;
import com.example.back.repository.LibraryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryMemberService {
    @Autowired
    LibraryMemberRepository libraryMemberRepository;

    public LibraryMember createLibraryMember(LibraryMember libraryMember) {
        return libraryMemberRepository.save(libraryMember);
    }

    public List<LibraryMember> getLibraryMember() {
        return libraryMemberRepository.findAll();
    }

    public void DeleteLibraryMember(int id) {
        libraryMemberRepository.deleteById(id);
    }

    public LibraryMember updateLibraryMember(LibraryMember libraryMember) {
        int libraryMemberId = libraryMember.getId();
        try {
            LibraryMember updateLibraryMember = libraryMemberRepository.findLibraryMemberById(libraryMemberId);
            if (updateLibraryMember != null) {
                updateLibraryMember = libraryMember;
                return libraryMemberRepository.save(libraryMember);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public LibraryMember findLibraryMemberId(int libraryMemberId) {
        try {
            return libraryMemberRepository.getById( libraryMemberId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
