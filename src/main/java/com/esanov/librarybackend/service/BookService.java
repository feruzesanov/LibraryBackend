package com.esanov.librarybackend.service;

import com.esanov.librarybackend.enums.Lang;
import com.esanov.librarybackend.request.BookAddReq;
import com.esanov.librarybackend.request.BookEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.BookResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<ResponseMessage> add(BookAddReq bookAddReq);

    ResponseEntity<List<BookResponse>> getAll(int page, int size, Lang lang);


    ResponseEntity<BookResponse> getOne(IdReq idReq);

    ResponseEntity<BookResponse> update(BookEditReq editReq);

    ResponseEntity<Boolean> delete(IdReq idReq);
}
