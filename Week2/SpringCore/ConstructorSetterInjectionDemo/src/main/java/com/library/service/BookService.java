package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private BookRepository backupBookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor injection: bookRepository set");
    }

    public void setBackupBookRepository(BookRepository backupBookRepository) {
        this.backupBookRepository = backupBookRepository;
        System.out.println("Setter injection: backupBookRepository set");
    }

    public String getBookFromRepository(int id) {
        return bookRepository.findBookById(id);
    }

    public String getBookFromBackupRepository(int id) {
        return backupBookRepository.findBookById(id);
    }
}