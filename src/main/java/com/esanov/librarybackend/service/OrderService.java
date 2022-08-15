package com.esanov.librarybackend.service;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.exceptions.CustomNotFoundException;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.OrderAddReq;
import com.esanov.librarybackend.request.OrderEditReq;
import com.esanov.librarybackend.response.OrderResponse;

import java.util.List;

public interface OrderService {

    ResponseData<OrderResponse> add(OrderAddReq orderReq) throws CustomNotFoundException;

    ResponseData<List<OrderResponse>> getAll(int page, int size);

    ResponseData<OrderResponse> getOne(IdReq idReq);

    ResponseData<OrderResponse> update(OrderEditReq editReq);

    ResponseData<Boolean> delete(IdReq idReq);
}
