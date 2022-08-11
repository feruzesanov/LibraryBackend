package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.enums.Lang;
import com.esanov.librarybackend.request.BookAddReq;
import com.esanov.librarybackend.request.BookEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.BookResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Filter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH + BOOK)
public class BookController {

    private final BookService bookService;

    @PostMapping(ADD)
    public ResponseData<ResponseMessage> add(@RequestBody BookAddReq bookAddReq) {
        return bookService.add(bookAddReq);
    }

    @GetMapping(GET + ALL)
    public ResponseData<List<BookResponse>> getAll(@PositiveOrZero @RequestParam(defaultValue = "0") int page,
                                                     @Positive @RequestParam(defaultValue = "10") int size,
                                                     @RequestParam(defaultValue = "ALL") Lang lang) {

        return bookService.getAll(page,size,lang);
    }


    @PostMapping(GET + ONE)
    public ResponseData<BookResponse> getOne(@RequestBody IdReq idReq) {
        return bookService.getOne(idReq);
    }

    @PostMapping(UPDATE)
    public ResponseData<BookResponse> update(@RequestBody BookEditReq editReq) {
        return bookService.update(editReq);
    }

    @PostMapping(DELETE)
    public ResponseData<Boolean> delete(@RequestBody IdReq idReq) {
        return bookService.delete(idReq);
    }

}
