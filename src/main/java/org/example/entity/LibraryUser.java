package org.example.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString



public class LibraryUser implements Comparable <LibraryUser>{
    private Long id;
    private String name;
    private Book bookRequestedFor;
    private Roles role;

    public LibraryUser(String name) {
        this.name = name;
    }

    public LibraryUser(Roles role) {
        this.role = role;
    }

    @Override
    public int compareTo(LibraryUser other) {
        if (this.getRole().equals(Roles.TEACHER) && !other.getRole().equals(Roles.TEACHER)) {
            return -1;
        } else if (!this.getRole().equals(Roles.TEACHER) && other.getRole().equals(Roles.TEACHER)) {
            return 1;
        } else if (this.getRole().equals(Roles.SENIOR_STUDENT) && other.getRole().equals(Roles.JUNIOR_STUDENT)) {
            return -1;
        } else if (this.getRole().equals(Roles.JUNIOR_STUDENT) && other.getRole().equals(Roles.SENIOR_STUDENT)) {
            return 1;
        } else if (this.getBookRequestedFor().getName().equals(other.getBookRequestedFor().getName())) {
            return 0;
        } else {
            return this.getBookRequestedFor().getName().compareTo(other.getBookRequestedFor().getName());
        }
    }

}





