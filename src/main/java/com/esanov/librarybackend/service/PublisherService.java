package com.esanov.librarybackend.service;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.PublishEditReq;
import com.esanov.librarybackend.request.PublisherAddReq;
import com.esanov.librarybackend.response.PublishResponse;
import com.esanov.librarybackend.response.ResponseMessage;

import java.util.List;

public interface PublisherService {
    ResponseData<ResponseMessage> add(PublisherAddReq publisherAddReq);

    ResponseData<List<PublishResponse>> getAll(int page, int size);

    ResponseData<PublishResponse> getOne(IdReq idReq);

    ResponseData<PublishResponse> update(PublishEditReq editReq);

    ResponseData<Boolean> delete(IdReq idReq);
}
