package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.entity.Book;
import com.esanov.librarybackend.enums.Lang;
import com.esanov.librarybackend.mapper.BookMapper;
import com.esanov.librarybackend.repository.BookRepository;
import com.esanov.librarybackend.request.BookAddReq;
import com.esanov.librarybackend.request.BookEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.BookResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public ResponseData<ResponseMessage> add(BookAddReq bookAddReq) {

        Book book = bookMapper.toReq(bookAddReq);
        bookRepository.save(book);
        return new ResponseData<>(new ResponseMessage("Book muvaffaqiyatli qo'shildi."));
    }

    @Override
    public ResponseData<List<BookResponse>> getAll(int page, int size, Lang lang) {

        if (lang == Lang.ALL) {
            List<Book> bookList = bookRepository.findAll(PageRequest.of(page, size,
                    Sort.by("createdAt").descending())).toList();
            List<BookResponse> bookResponseList = bookMapper.toResp(bookList);
            return new ResponseData<>(bookResponseList);
        } else {
            List<Book> bookList = bookRepository.findAllByLang(lang, PageRequest.of(page, size,
                    Sort.by("createdAt").descending()));

            List<BookResponse> bookResponseList = bookMapper.toResp(bookList);
            return new ResponseData<>(bookResponseList);

        }
    }

    @Override
    public ResponseData<BookResponse> getOne(IdReq idReq) {
        Optional<Book> bookOptional = bookRepository.findById(idReq.getId());
        if (bookOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik book yoq.");
        }
        Book book = bookOptional.get();
        return new ResponseData<>(bookMapper.toResp(book));
    }

    @Override
    public ResponseData<BookResponse> update(BookEditReq editReq) {
        Optional<Book> bookOptional = bookRepository.findById(editReq.getId());
        if (bookOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik book yoq");
        }
        Book book = bookOptional.get();
        Book book1 = bookMapper.toEntity(book, editReq);
        bookRepository.save(book1);
        return new ResponseData<>(bookMapper.toResp(book1));
    }

    @Override
    public ResponseData<Boolean> delete(IdReq idReq) {
        if (!bookRepository.existsById(idReq.getId())) {
            throw new RuntimeException("Bunday idlik book yoq");
        }
        bookRepository.deleteById(idReq.getId());
        return new ResponseData<>(true);
    }

    @Override
    public Boolean isExistsBook(Long id) {
        if (bookRepository.existsById(id)) {
            return true;
        }
        return false;

    }

}