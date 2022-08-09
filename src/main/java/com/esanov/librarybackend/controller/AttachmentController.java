package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.AttachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH + ATTACH)
public class AttachmentController {
    private final AttachService attachService;

    @PostMapping(UPLOAD)
    public ResponseEntity<ResponseMessage> uploadAttachment(@RequestParam("file") MultipartFile file) {
        return attachService.uploadAttachment(file);
    }

}
