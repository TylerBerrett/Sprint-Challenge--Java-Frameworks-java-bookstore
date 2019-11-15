package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.repository.BookRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(bookList::add);
        return bookList;
    }

    @Override
    public Book updateBook(long bookid, Book book) {
        Book getBook = bookRepository.findById(bookid).orElseThrow(() -> new ResourceNotFoundException(Long.toString(bookid)));

        //Book test = new Book(booktitle, isbn, copy, section)

        if (book.getBooktitle() != null) {
            getBook.setBooktitle(book.getBooktitle());
        }

        if (book.getIsbn() != null ) {
            getBook.setIsbn(book.getIsbn());
        }

        if (Long.toString(book.getCopy()) != "null") {
            getBook.setCopy(book.getCopy());
        }

        if (book.getSection() != null && book.getSection().getSectionname() != null) {
            getBook.setSection(book.getSection());
        }

        if (book.getWrote().size() > 0) {
            throw new ResourceNotFoundException("this isn't the update end point you are looking for");
        }

        return bookRepository.save(getBook);
    }

    @Override
    public void addBook(long bookid, long authorid) {
        bookRepository.findById(bookid).orElseThrow(() -> new ResourceNotFoundException(Long.toString(bookid)));
        bookRepository.findById(authorid).orElseThrow(() -> new ResourceNotFoundException(Long.toString(authorid)));
        bookRepository.insertWrote(bookid, authorid);

    }

    @Override
    public void deleteBook(long bookid) {
        bookRepository.deleteById(bookid);
    }
}
