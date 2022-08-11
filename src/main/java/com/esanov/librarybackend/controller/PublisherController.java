package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.PublishEditReq;
import com.esanov.librarybackend.request.PublisherAddReq;
import com.esanov.librarybackend.response.PublishResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH+PUBLISHER)
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping(ADD)
    public ResponseData<ResponseMessage> add(@RequestBody PublisherAddReq publisherAddReq){
        return publisherService.add(publisherAddReq);

    }
    @GetMapping(GET+ALL)
    public ResponseData<List<PublishResponse>> getAll(@PositiveOrZero @RequestParam(defaultValue = "0") int page,
                                                        @Positive @RequestParam(defaultValue = "10") int size){
        return publisherService.getAll(page,size);
    }

    @PostMapping(GET+ONE)
    public ResponseData<PublishResponse> getOne(@RequestBody IdReq idReq){
        return publisherService.getOne(idReq);
    }

    @PostMapping(UPDATE)
    public ResponseData<PublishResponse> update(@RequestBody PublishEditReq editReq){
        return publisherService.update(editReq);
    }

    @PostMapping(DELETE)
    public ResponseData<Boolean> delete(@RequestBody IdReq idReq){
        return publisherService.delete(idReq);
    }


}
