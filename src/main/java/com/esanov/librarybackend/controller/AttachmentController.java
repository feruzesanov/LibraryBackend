package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.AttachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/download/{fileName:.+}")
    public void downloadFile(HttpServletResponse response,
                             @PathVariable("fileName") String fileName) {
        attachService.downloadFile(fileName, response);
    }

}
