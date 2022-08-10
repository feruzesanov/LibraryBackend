package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.entity.Order;
import com.esanov.librarybackend.mapper.OrderMapper;
import com.esanov.librarybackend.repository.OrderRepo;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.OrderEditReq;
import com.esanov.librarybackend.request.OrderReq;
import com.esanov.librarybackend.response.OrderResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    @Override
    public ResponseEntity<ResponseMessage> add(OrderReq orderReq) {

        Order order = orderMapper.toDomain(orderReq);
        orderRepo.save(order);
        return ResponseEntity.ok(new ResponseMessage("Order kiritildi."));

    }

    @Override
    public ResponseEntity<List<OrderResponse>> getAll(int page, int size) {
        List<Order> orderList = orderRepo.findAll(PageRequest.of(page,size)).toList();
        return ResponseEntity.ok(orderMapper.toRes(orderList));
    }

    @Override
    public ResponseEntity<OrderResponse> getOne(IdReq idReq) {

        Optional<Order> orderOptional = orderRepo.findById(idReq.getId());
        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik order yoq.");
        }
        return ResponseEntity.ok(orderMapper.toRes(orderOptional.get()));
    }

    @Override
    public ResponseEntity<OrderResponse> update(OrderEditReq editReq) {

        Optional<Order> orderOptional = orderRepo.findById(editReq.getId());
        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik order yoq");
        }
        Order order = orderMapper.toEntity(orderOptional.get(), editReq);
        orderRepo.save(order);
        return ResponseEntity.ok(orderMapper.toRes(order));
    }

    @Override
    public ResponseEntity<Boolean> delete(IdReq idReq) {

        Optional<Order> orderOptional = orderRepo.findById(idReq.getId());
        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik order yoq");
        }
        orderRepo.deleteById(idReq.getId());
        return ResponseEntity.ok(true);
    }
}
