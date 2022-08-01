package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.base.BaseURI;
import com.esanov.librarybackend.request.BookAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH+BOOK)
public class BookController {

    private final BookService bookService;

    @PostMapping(UPLOAD)
    public ResponseEntity<ResponseMessage> uploadAttachment(@RequestParam("file") MultipartFile file){
        return bookService.uploadAttachment(file);
    }

    @PostMapping(ADD)
    public ResponseEntity<ResponseMessage> add(@RequestBody BookAddReq bookAddReq){
        return bookService.add(bookAddReq);
    }

}
