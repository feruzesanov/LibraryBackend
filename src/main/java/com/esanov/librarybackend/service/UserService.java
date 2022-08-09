package com.esanov.librarybackend.service;

import com.esanov.librarybackend.request.EmailReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.UserAddReq;
import com.esanov.librarybackend.request.UserEditReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<ResponseMessage> add(UserAddReq userAddReq);

    ResponseEntity<List<UserResponse>> getAll(int page, int size);

    ResponseEntity<UserResponse> getOne(IdReq idReq);

    ResponseEntity<UserResponse> update(UserEditReq editReq);

    ResponseEntity<Boolean> delete(IdReq idReq);

    ResponseEntity<List<ResponseMessage>> downloadUrl(EmailReq emailReq);
}
