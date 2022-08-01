package com.esanov.librarybackend.service;

import com.esanov.librarybackend.request.BookAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface BookService {
    ResponseEntity<ResponseMessage> uploadAttachment(MultipartFile file);

    ResponseEntity<ResponseMessage> add(BookAddReq bookAddReq);
}
