package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Loggable
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    BookService bookService;
    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody Book book, HttpServletRequest request) {
        logger.info(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        bookService.updateBook(id, book);
        return new ResponseEntity<>(book.getBooktitle() + " has been updated", HttpStatus.OK);
    }

    @PostMapping(value = "/books/{bookid}/authors/{authorid}")
    public ResponseEntity<?> addBook(@PathVariable long bookid, @PathVariable long authorid, HttpServletRequest request) {
        logger.info(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        bookService.addBook(bookid, authorid);
        return new ResponseEntity<>("Book has been added", HttpStatus.OK);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id, HttpServletRequest request) {
        logger.info(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book has been deleted", HttpStatus.OK);
    }


}
