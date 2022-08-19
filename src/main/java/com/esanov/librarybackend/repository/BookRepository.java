package com.esanov.librarybackend.repository;

import com.esanov.librarybackend.entity.Book;
import com.esanov.librarybackend.enums.Lang;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByLang(Lang lang, PageRequest of);

    List<Book> findAllByAuthorIdIn(List<Long> authorId);
}
