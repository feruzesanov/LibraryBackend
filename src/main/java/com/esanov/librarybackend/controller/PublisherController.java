package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.base.BaseURI;
import com.esanov.librarybackend.request.PublisherAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH+PUBLISHER)
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping(ADD)
    public ResponseEntity<ResponseMessage> add(@RequestBody PublisherAddReq publisherAddReq){
        return publisherService.add(publisherAddReq);

    }

}
