package com.esanov.librarybackend.service;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.request.AuthorEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.AuthorResponce;
import com.esanov.librarybackend.response.ResponseMessage;

import java.util.List;

public interface AuthorService {
    ResponseData<ResponseMessage> add(AuthorAddReq authorAddReq);


    ResponseData<List<AuthorResponce>> getAll(int page, int size);

    ResponseData<AuthorResponce> getOne(IdReq idReq);

    ResponseData<AuthorResponce> update(AuthorEditReq editReq);

    ResponseData<Boolean> delete(IdReq idReq);
}
