package org.example;

import org.example.entity.*;
import org.example.service.LibraryService;
import org.example.service.LibraryUserService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Book book = new Book (4l,"Modern Physics","mr Ernest",2);
        Book book1 = new Book(2l,"Modern Biology", "C.S Jaja",2);

        LibraryUser teacher = new LibraryUser(32l,"Juliet",book1, Roles.TEACHER);
        LibraryUser seniorStudent = new LibraryUser(33l,"Jennifer",book,Roles.SENIOR_STUDENT);
        LibraryUser juniorStudent = new LibraryUser(34l,"Hosea",book,Roles.JUNIOR_STUDENT);
        LibraryUser librarian = new LibraryUser(35l,"kelvin",book1,Roles.LIBRARIAN);


        LibraryUser teacher2 = new LibraryUser(32l,"Ugo",book1, Roles.TEACHER);
        LibraryUser seniorStudent2 = new LibraryUser(33l,"Jenny",book,Roles.SENIOR_STUDENT);
        LibraryUser juniorStudent3 = new LibraryUser(34l,"Hope",book,Roles.JUNIOR_STUDENT);
        LibraryUser librarian1 = new LibraryUser(35l,"ike",book1,Roles.LIBRARIAN);

        List<LibraryUser> fifoList = new ArrayList<>();
        Set<Book> bookSet = new HashSet<Book>();
        Library library = new Library();
        bookSet.add(book1);
        bookSet.add(book);
        library.setBookSet(bookSet);
        library.setFifoList(fifoList);
        System.out.println(bookSet);



        LibraryUserService libraryUserService = new LibraryUserService();
        libraryUserService.fifoBookRequest(juniorStudent, library);
        libraryUserService.fifoBookRequest(seniorStudent, library);
        libraryUserService.fifoBookRequest(teacher,library);

        libraryUserService.fifoBookRequest(juniorStudent3, library);
        libraryUserService.fifoBookRequest(seniorStudent2, library);
        libraryUserService.fifoBookRequest(teacher2,library);
        Collections.sort(library.getFifoList());

        System.out.println(library.getFifoList().toString());

        LibraryService libraryService = new LibraryService();
        String result = libraryService.toIssueBook(library,librarian);
        System.out.println(result);

    }
    }
