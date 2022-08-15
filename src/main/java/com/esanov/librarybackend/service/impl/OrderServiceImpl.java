package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.entity.Order;
import com.esanov.librarybackend.exceptions.CustomNotFoundException;
import com.esanov.librarybackend.mapper.OrderMapper;
import com.esanov.librarybackend.repository.OrderRepo;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.OrderAddReq;
import com.esanov.librarybackend.request.OrderEditReq;
import com.esanov.librarybackend.response.OrderResponse;
import com.esanov.librarybackend.service.BookService;
import com.esanov.librarybackend.service.OrderService;
import com.esanov.librarybackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.esanov.librarybackend.base.MessageKey.BOOK_NOT_FOUND;
import static com.esanov.librarybackend.base.MessageKey.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    private final UserService userService;
    private final BookService bookService;

    @Override
    public ResponseData<OrderResponse> add(OrderAddReq orderReq) throws CustomNotFoundException {
        if (!userService.isExistsUser(orderReq.getUserId())) {
            throw new CustomNotFoundException(USER_NOT_FOUND);
        }
        if (!bookService.isExistsBook(orderReq.getBookId())) {
            throw new CustomNotFoundException(BOOK_NOT_FOUND);
        } else {
            Order order = orderMapper.toDomain(orderReq);
            orderRepo.save(order);
            return new ResponseData<>(orderMapper.toRes(order));
        }
    }

    @Override
    public ResponseData<List<OrderResponse>> getAll(int page, int size) {
        List<Order> orderList = orderRepo.findAll(PageRequest.of(page, size)).toList();
        return new ResponseData<>(orderMapper.toRes(orderList));
    }

    @Override
    public ResponseData<OrderResponse> getOne(IdReq idReq) {

        Optional<Order> orderOptional = orderRepo.findById(idReq.getId());
        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik order yoq.");
        }
        return new ResponseData<>(orderMapper.toRes(orderOptional.get()));
    }

    @Override
    public ResponseData<OrderResponse> update(OrderEditReq editReq) {

        Optional<Order> orderOptional = orderRepo.findById(editReq.getId());
        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik order yoq");
        }
        Order order = orderMapper.toEntity(orderOptional.get(), editReq);
        orderRepo.save(order);
        return new ResponseData<>(orderMapper.toRes(order));
    }

    @Override
    public ResponseData<Boolean> delete(IdReq idReq) {

        Optional<Order> orderOptional = orderRepo.findById(idReq.getId());
        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik order yoq");
        }
        orderRepo.deleteById(idReq.getId());
        return new ResponseData<>(true);
    }
}
