package com.esanov.librarybackend.service;

import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface AttachService {

    ResponseEntity<ResponseMessage> uploadAttachment(MultipartFile file);

    void downloadFile(String fileName, HttpServletResponse response);
}
