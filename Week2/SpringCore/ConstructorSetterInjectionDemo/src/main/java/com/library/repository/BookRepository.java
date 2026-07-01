package com.library.repository;

public class BookRepository {

    public String findBookById(int id) {
        return "Book with id " + id + ": The Alchemist";
    }
}