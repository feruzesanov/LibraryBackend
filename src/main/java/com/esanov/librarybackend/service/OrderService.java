package com.esanov.librarybackend.service;

import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.OrderEditReq;
import com.esanov.librarybackend.request.OrderReq;
import com.esanov.librarybackend.response.OrderResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    ResponseEntity<ResponseMessage> add(OrderReq orderReq);

    ResponseEntity<List<OrderResponse>> getAll(int page, int size);

    ResponseEntity<OrderResponse> getOne(IdReq idReq);

    ResponseEntity<OrderResponse> update(OrderEditReq editReq);

    ResponseEntity<Boolean> delete(IdReq idReq);
}
