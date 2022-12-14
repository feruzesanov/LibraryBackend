package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.entity.Author;
import com.esanov.librarybackend.exceptions.CustomAlreadyException;
import com.esanov.librarybackend.mapper.AuthorMapper;
import com.esanov.librarybackend.repository.AuthorRepository;
import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.request.AuthorEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.AuthorResponce;
import com.esanov.librarybackend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.esanov.librarybackend.base.MessageKey.AUTHOR_ALREADY_EXISTS;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    @Override
    public ResponseData<AuthorResponce> add(AuthorAddReq authorAddReq) throws CustomAlreadyException {

        Optional<Author> authorOptional = authorRepository
                .findByFullName(authorAddReq.getFullName());
        if (authorOptional.isPresent()) {
            throw new CustomAlreadyException(AUTHOR_ALREADY_EXISTS);
        }
        Author author = authorMapper.toReq(authorAddReq);
        authorRepository.save(author);
        return new ResponseData<>(authorMapper.toRes(author));

    }

    @Override
    public ResponseData<List<AuthorResponce>> getAll(int page, int size) {

        List<Author> authorList = authorRepository.findAll(PageRequest.of(page, size)).toList();
        return new ResponseData<>(authorMapper.toRes(authorList));

    }

    @Override
    public ResponseData<AuthorResponce> getOne(IdReq idReq) {

        Optional<Author> authorOptional = authorRepository.findById(idReq.getId());
        if (authorOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik student yoq");
        }
        Author author = authorOptional.get();
        return new ResponseData<>(authorMapper.toRes(author));
    }

    @Override
    public ResponseData<AuthorResponce> update(AuthorEditReq editReq) {

        Optional<Author> authorOptional = authorRepository.findById(editReq.getId());
        if (authorOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik authow mavjud emas");
        }
        Author author = authorOptional.get();
        Author author1 = authorMapper.toEntity(author, editReq);
        authorRepository.save(author1);
        return new ResponseData<>(authorMapper.toRes(author1));
    }

    @Override
    public ResponseData<Boolean> delete(IdReq idReq) {
        if (!authorRepository.existsById(idReq.getId())) {
            throw new RuntimeException("Bunday idlik author yoq");
        }
        authorRepository.deleteById(idReq.getId());
        return new ResponseData<>(true);
    }

    @Override
    public Boolean alreadyAuthor(Long id) {
        if (authorRepository.existsById(id)) {
            return true;
        }
        return false;
    }


}
