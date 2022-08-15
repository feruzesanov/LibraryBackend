package com.esanov.librarybackend.service;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.request.EmailReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.UserAddReq;
import com.esanov.librarybackend.request.UserEditReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.response.UserResponse;

import java.util.List;

public interface UserService {
    ResponseData<ResponseMessage> add(UserAddReq userAddReq);

    ResponseData<List<UserResponse>> getAll(int page, int size);

    ResponseData<UserResponse> getOne(IdReq idReq);

    ResponseData<UserResponse> update(UserEditReq editReq);

    ResponseData<Boolean> delete(IdReq idReq);

    ResponseData<List<ResponseMessage>> downloadUrl(EmailReq emailReq);

    Boolean isExistsUser(Long id);
}
