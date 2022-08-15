package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.exceptions.CustomNotFoundException;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.OrderAddReq;
import com.esanov.librarybackend.request.OrderEditReq;
import com.esanov.librarybackend.response.OrderResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseData<OrderResponse> add(@RequestBody @Valid OrderAddReq orderAddReq) throws CustomNotFoundException {
        return orderService.add(orderAddReq);
    }

    @GetMapping(GET + ALL)
    public ResponseData<List<OrderResponse>> getAll(@PositiveOrZero @RequestParam(defaultValue = "0") int page,
                                                      @Positive @RequestParam(defaultValue = "10") int size){
        return orderService.getAll(page,size);
    }

    @PostMapping(GET+ONE)
    public ResponseData<OrderResponse> getOne(@RequestBody @Valid IdReq idReq){
        return orderService.getOne(idReq);
    }

    @PostMapping(UPDATE)
    public ResponseData<OrderResponse> update(@RequestBody @Valid OrderEditReq editReq){
        return orderService.update(editReq);
    }

    @PostMapping(DELETE)
    public ResponseData<Boolean> delete(@RequestBody @Valid IdReq idReq){
        return orderService.delete(idReq);
    }
}
