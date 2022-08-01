package com.esanov.librarybackend.service;

import com.esanov.librarybackend.request.PublisherAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;

public interface PublisherService {
    ResponseEntity<ResponseMessage> add(PublisherAddReq publisherAddReq);
}
