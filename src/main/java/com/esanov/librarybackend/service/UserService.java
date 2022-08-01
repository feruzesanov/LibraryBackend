package com.esanov.librarybackend.service;

import com.esanov.librarybackend.request.UserAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<ResponseMessage> add(UserAddReq userAddReq);
}
