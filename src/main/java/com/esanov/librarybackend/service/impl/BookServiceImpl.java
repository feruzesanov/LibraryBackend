package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.entity.Attachment;
import com.esanov.librarybackend.entity.Book;
import com.esanov.librarybackend.entity.Publisher;
import com.esanov.librarybackend.mapper.BookMapper;
import com.esanov.librarybackend.repository.AttachmentRepository;
import com.esanov.librarybackend.repository.AuthorRepository;
import com.esanov.librarybackend.repository.BookRepository;
import com.esanov.librarybackend.repository.PublisherRepository;
import com.esanov.librarybackend.request.BookAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AttachmentRepository attachmentRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final BookMapper bookMapper;

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
    public ResponseEntity<ResponseMessage> add(BookAddReq bookAddReq) {
        if (!authorRepository.existsById(bookAddReq.getAuthorId())){
            throw new RuntimeException("Bunday idlik author yoq.");
        }
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(bookAddReq.getAttachmentId());
        if (attachmentOptional.isEmpty()){
            throw new RuntimeException("Bunday idlik attachment yoq.");
        }
        Optional<Publisher> publisherOptional = publisherRepository.findById(bookAddReq.getPublisherId());
        if (publisherOptional.isEmpty()){
            throw new RuntimeException("publisher.already.exists");
        }
        Book book = bookMapper.toReq(bookAddReq);
        book.setAuthor(authorRepository.findById(book.getAuthorId()).get());
        bookRepository.save(book);
        return ResponseEntity.ok(new ResponseMessage("Book muvaffaqiyatli qo'shildi."));
    }
}
