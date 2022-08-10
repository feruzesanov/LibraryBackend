package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.OrderEditReq;
import com.esanov.librarybackend.request.OrderReq;
import com.esanov.librarybackend.response.OrderResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH + ORDER)
public class OrderController {

    private final OrderService orderService;

    @PostMapping(ADD)
    public ResponseEntity<ResponseMessage> add(@RequestBody OrderReq orderReq) {
        return orderService.add(orderReq);
    }

    @GetMapping(GET + ALL)
    public ResponseEntity<List<OrderResponse>> getAll(@PositiveOrZero @RequestParam(defaultValue = "0") int page,
                                                      @Positive @RequestParam(defaultValue = "10") int size){
        return orderService.getAll(page,size);
    }

    @PostMapping(GET+ONE)
    public ResponseEntity<OrderResponse> getOne(@RequestBody IdReq idReq){
        return orderService.getOne(idReq);
    }

    @PostMapping(UPDATE)
    public ResponseEntity<OrderResponse> update(@RequestBody OrderEditReq editReq){
        return orderService.update(editReq);
    }

    @PostMapping(DELETE)
    public ResponseEntity<Boolean> delete(@RequestBody IdReq idReq){
        return orderService.delete(idReq);
    }
}
