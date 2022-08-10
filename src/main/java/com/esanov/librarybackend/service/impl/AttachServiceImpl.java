package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.entity.Attachment;
import com.esanov.librarybackend.repository.AttachmentRepository;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.AttachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttachServiceImpl implements AttachService {

    private final AttachmentRepository attachmentRepository;
    @Override
    public ResponseEntity<ResponseMessage> uploadAttachment(MultipartFile file) {
        String[] array = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        String generatedName = UUID.randomUUID() + "." + array[array.length - 1];

        String pathProject = System.getProperty("user.dir") + "/src/main/resources/static/";

        try {
            file.transferTo(new File(pathProject + generatedName));
        } catch (IOException e) {
            throw new RuntimeException("File upload qilishdada muammo.");
        }

        Attachment attachment = Attachment.builder()
                .generatedName(generatedName)
                .originalName(file.getOriginalFilename())
                .type(file.getContentType())
                .size(file.getSize())
                .build();

        attachmentRepository.save(attachment);

        return ResponseEntity.ok(new ResponseMessage("Book muvaffaqiyatli upload qilindi."));

    }

    @Override
    public void downloadFile(String fileName, HttpServletResponse response) {

        final String EXTERNAL_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/static/";
        try {
            File file = new File(EXTERNAL_FILE_PATH + fileName);
            if (file.exists()) {
                response.setContentType("application/octoc-stream");
                String headerKey = "Content-Disposition";
                String headerValue = "attachment;filename=" + file.getName();

                response.setHeader(headerKey, headerValue);

                InputStream inputStream = Files.newInputStream(file.toPath());

                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(inputStream.readAllBytes());
            }
        } catch (Exception e) {
            throw new RuntimeException("Bunday Url mavjud emas");
        }

    }
}
