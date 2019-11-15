package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.repository.AuthorRepository;
import com.lambdaschool.usermodel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authorList = new ArrayList<>();
        authorRepository.findAll().iterator().forEachRemaining(authorList::add);
        return authorList;
    }
}
