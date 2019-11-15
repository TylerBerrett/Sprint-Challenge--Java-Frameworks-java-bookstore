package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.services.AuthorService;
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
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @GetMapping(value = "/authors")
    public ResponseEntity<?> getAuthors(HttpServletRequest request) {
        logger.info(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

}
