package com.eny.bookretail.repository;

import com.eny.bookretail.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findBookEntityById(long id);

    List<BookEntity> findAll();

    List<BookEntity> findBookEntityByAuthor(String author);

    Optional<BookEntity> findBookEntityByAuthorAndName(String author, String name);

}