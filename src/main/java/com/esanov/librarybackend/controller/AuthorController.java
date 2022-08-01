package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH + AUTHOR)
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping(ADD)
    public ResponseEntity<ResponseMessage> add(@RequestBody AuthorAddReq authorAddReq) {
        return authorService.add(authorAddReq);
    }
}
