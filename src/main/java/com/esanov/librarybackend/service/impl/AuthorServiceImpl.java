package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.entity.Author;
import com.esanov.librarybackend.mapper.AuthorMapper;
import com.esanov.librarybackend.repository.AuthorRepository;
import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public ResponseEntity<ResponseMessage> add(AuthorAddReq authorAddReq) {

        Optional<Author> authorOptional = authorRepository
                .findByFullName(authorAddReq.getFullName());
        if (authorOptional.isPresent()) {
            throw new RuntimeException("Bunday ismli author mavjud.");
        }

        Author author = authorMapper.toReq(authorAddReq);
        authorRepository.save(author);
        return ResponseEntity.ok(new ResponseMessage("Author muvaffaqiyatli qo'shildi."));

    }
}
