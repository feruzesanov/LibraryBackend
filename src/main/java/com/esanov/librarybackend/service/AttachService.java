package com.esanov.librarybackend.service;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.response.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface AttachService {

    ResponseData<ResponseMessage> uploadAttachment(MultipartFile file);

    void downloadFile(String fileName, HttpServletResponse response);
}
