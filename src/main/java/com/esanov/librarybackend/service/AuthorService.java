package com.esanov.librarybackend.service;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.exceptions.CustomAlreadyException;
import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.request.AuthorEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.AuthorResponce;

import java.util.List;

public interface AuthorService {
    ResponseData<AuthorResponce> add(AuthorAddReq authorAddReq) throws CustomAlreadyException;


    ResponseData<List<AuthorResponce>> getAll(int page, int size);

    ResponseData<AuthorResponce> getOne(IdReq idReq);

    ResponseData<AuthorResponce> update(AuthorEditReq editReq);

    ResponseData<Boolean> delete(IdReq idReq);

    Boolean alreadyAuthor(Long id);
}
