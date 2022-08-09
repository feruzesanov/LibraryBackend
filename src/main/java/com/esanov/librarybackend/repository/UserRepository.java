package com.esanov.librarybackend.repository;

import com.esanov.librarybackend.entity.User;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("select u.id from User u where u.email=?1")
    Long userIdByEmail(String email);

    @Query("select o.bookId from Order o where o.userId=?1")
    List<Long> bookIdByUserId(Long userId);

    @Query("select b.attachmentId from Book b where b.id=?1")
    List<Long> attachmentIdOrderBookId(Long bookId);

    @Query("SELECT a.generatedName FROM Attachment a WHERE a.id = ?1")
    String attachmentUrl(Long attachmentId);

}
