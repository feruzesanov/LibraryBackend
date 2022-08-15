package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.exceptions.CustomAlreadyException;
import com.esanov.librarybackend.request.AuthorAddReq;
import com.esanov.librarybackend.request.AuthorEditReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.response.AuthorResponce;
import com.esanov.librarybackend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH + AUTHOR)
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping(ADD)
    public ResponseData<AuthorResponce> add(@RequestBody @Valid AuthorAddReq authorAddReq) throws CustomAlreadyException {
        return authorService.add(authorAddReq);
    }

    @GetMapping(GET + ALL)
    public ResponseData<List<AuthorResponce>> getAll(@PositiveOrZero @RequestParam(defaultValue = "0") int page,
                                                       @Positive @RequestParam(defaultValue = "10")  int size) {
        return authorService.getAll(page,size);
    }

    @PostMapping(GET + ONE)
    public ResponseData<AuthorResponce> getOne(@RequestBody @Valid IdReq idReq) {
        return authorService.getOne(idReq);
    }

    @PostMapping(UPDATE)
    public ResponseData<AuthorResponce> update(@RequestBody @Valid AuthorEditReq editReq) {
        return authorService.update(editReq);
    }

    @PostMapping(DELETE)
    public ResponseData<Boolean> delete(@RequestBody @Valid IdReq idReq) {
        return authorService.delete(idReq);
    }

}
