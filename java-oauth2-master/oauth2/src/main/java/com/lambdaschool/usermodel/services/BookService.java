package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book updateBook(long bookid, Book book);

    void addBook(long bookid, long authorid);

    void deleteBook(long bookid);
}
