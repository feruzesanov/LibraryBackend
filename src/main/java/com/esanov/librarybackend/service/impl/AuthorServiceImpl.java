package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.entity.Author;
import com.esanov.librarybackend.mapper.AuthorMapper;
import com.esanov.librarybackend.repository.AuthorRepository;
import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.request.AuthorEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.AuthorResponce;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    @Override
    public ResponseEntity<List<AuthorResponce>> getAll(int page, int size) {

        List<Author> authorList = authorRepository.findAll(PageRequest.of(page, size)).toList();
        return ResponseEntity.ok(authorMapper.toRes(authorList));

    }

    @Override
    public ResponseEntity<AuthorResponce> getOne(IdReq idReq) {

        Optional<Author> authorOptional = authorRepository.findById(idReq.getId());
        if (authorOptional.isEmpty()){
            throw new RuntimeException("Bunday idlik student yoq");
        }
        Author author = authorOptional.get();
        return ResponseEntity.ok(authorMapper.toRes(author));
    }

    @Override
    public ResponseEntity<AuthorResponce> update(AuthorEditReq editReq) {

        Optional<Author> authorOptional = authorRepository.findById(editReq.getId());
        if (authorOptional.isEmpty()){
            throw new RuntimeException("Bunday idlik authow mavjud emas");
        }
        Author author = authorOptional.get();
        Author author1 = authorMapper.toEntity(author, editReq);
        authorRepository.save(author1);
        return ResponseEntity.ok(authorMapper.toRes(author1));
    }

    @Override
    public ResponseEntity<Boolean> delete(IdReq idReq) {
        if (!authorRepository.existsById(idReq.getId())){
            throw new RuntimeException("Bunday idlik author yoq");
        }
        authorRepository.deleteById(idReq.getId());
        return ResponseEntity.ok(true);
    }


}
