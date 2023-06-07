package org.example.service;

import org.example.entity.Library;
import org.example.entity.LibraryUser;

import java.util.ArrayList;
import java.util.List;

public class LibraryUserService {
    public List<LibraryUser> fifoBookRequest(LibraryUser libraryUser, Library library){
        List<LibraryUser>fifoList= library.getFifoList();
        fifoList.add(libraryUser);
        return fifoList;
    }
}


