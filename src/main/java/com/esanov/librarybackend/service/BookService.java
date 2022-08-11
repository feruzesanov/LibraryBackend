package com.esanov.librarybackend.service;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.enums.Lang;
import com.esanov.librarybackend.request.BookAddReq;
import com.esanov.librarybackend.request.BookEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.BookResponse;
import com.esanov.librarybackend.response.ResponseMessage;

import java.util.List;

public interface BookService {
    ResponseData<ResponseMessage> add(BookAddReq bookAddReq);

    ResponseData<List<BookResponse>> getAll(int page, int size, Lang lang);


    ResponseData<BookResponse> getOne(IdReq idReq);

    ResponseData<BookResponse> update(BookEditReq editReq);

    ResponseData<Boolean> delete(IdReq idReq);
}
