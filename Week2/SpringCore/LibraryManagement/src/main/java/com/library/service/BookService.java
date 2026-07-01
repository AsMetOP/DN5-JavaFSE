package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String getBookDetails(int id) {
        return "Fetching details for book id " + id;
    }

    public String getBookFromRepository(int id) {
        return bookRepository.findBookById(id);
    }
}