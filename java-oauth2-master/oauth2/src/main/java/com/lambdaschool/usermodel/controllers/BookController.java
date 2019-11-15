package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.services.AuthorService;
import com.lambdaschool.usermodel.services.BookService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Loggable
@RestController
@Api(tags = {"BookEndpoint"})
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping(value = "/books")
    public ResponseEntity<?> getBooks(HttpServletRequest request) {
        logger.info(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

}
