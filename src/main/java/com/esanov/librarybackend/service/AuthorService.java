package com.esanov.librarybackend.service;

import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;

public interface AuthorService {


    ResponseEntity<ResponseMessage> add(AuthorAddReq authorAddReq);
}
