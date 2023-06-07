package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Library {
    Set<Book>bookSet;
    List<LibraryUser> fifoList;

}
