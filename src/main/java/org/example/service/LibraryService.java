package org.example.service;

import org.example.entity.Book;
import org.example.entity.Library;
import org.example.entity.LibraryUser;
import org.example.entity.Roles;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LibraryService {
public String toIssueBook(Library library, LibraryUser libraryUser) {
    List<LibraryUser> fifoList = library.getFifoList();
    Set<Book> bookSet = library.getBookSet();

    if (!libraryUser.getRole().equals(Roles.LIBRARIAN)) {
        return "You are unauthorized to issue a book";
    }

    boolean isBookTaken = bookSet.stream()
            .anyMatch(b -> b.getQuantity() <= 0);

    if (isBookTaken) {
        return "Book taken";
    }

    Optional<String> borrower = fifoList.stream()
            .filter(user -> user.getBookRequestedFor().equals(libraryUser.getBookRequestedFor()))
            .map(user -> user.getName() + " has borrowed this book")
            .findFirst();

    return borrower.orElse("Book borrowed");
}

}

