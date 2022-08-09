package com.esanov.librarybackend.service;

import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.PublishEditReq;
import com.esanov.librarybackend.request.PublisherAddReq;
import com.esanov.librarybackend.response.PublishResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublisherService {
    ResponseEntity<ResponseMessage> add(PublisherAddReq publisherAddReq);

    ResponseEntity<List<PublishResponse>> getAll(int page,int size);

    ResponseEntity<PublishResponse> getOne(IdReq idReq);

    ResponseEntity<PublishResponse> update(PublishEditReq editReq);

    ResponseEntity<Boolean> delete(IdReq idReq);
}
