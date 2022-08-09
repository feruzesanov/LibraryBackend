package com.esanov.librarybackend.service;

import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.request.AuthorEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.AuthorResponce;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {
    ResponseEntity<ResponseMessage> add(AuthorAddReq authorAddReq);


    ResponseEntity<List<AuthorResponce>> getAll(int page, int size);

    ResponseEntity<AuthorResponce> getOne(IdReq idReq);

    ResponseEntity<AuthorResponce> update(AuthorEditReq editReq);

    ResponseEntity<Boolean> delete(IdReq idReq);
}
