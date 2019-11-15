package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.models.Useremail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote(bookid, authorid) VALUES (:bookid, :authorid)", nativeQuery = true)
    void insertWrote(long bookid, long authorid);

}
