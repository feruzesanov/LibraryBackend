package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.request.EmailReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.UserAddReq;
import com.esanov.librarybackend.request.UserEditReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.response.UserResponse;
import com.esanov.librarybackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH + USER)
public class UserController {
    private final UserService userService;

    @PostMapping(ADD)
    public ResponseEntity<ResponseMessage> add(@RequestBody UserAddReq userAddReq) {
        return userService.add(userAddReq);
    }

    @GetMapping(GET + ALL)
    public ResponseEntity<List<UserResponse>> getAll(@PositiveOrZero @RequestParam(defaultValue = "0") int page,
                                                     @Positive @RequestParam(defaultValue = "10") int size) {
        return userService.getAll(page,size);
    }

    @PostMapping(GET + ONE)
    public ResponseEntity<UserResponse> getOne(@RequestBody IdReq idReq) {
        return userService.getOne(idReq);
    }

    @PostMapping(UPDATE)
    public ResponseEntity<UserResponse> update(@RequestBody UserEditReq editReq) {
        return userService.update(editReq);
    }

    @PostMapping(DELETE)
    public ResponseEntity<Boolean> delete(@RequestBody IdReq idReq) {
        return userService.delete(idReq);
    }

    @PostMapping(DOWNLOAD)
    public ResponseEntity<List<ResponseMessage>> downloadUrl(@RequestBody EmailReq emailReq){
        return userService.downloadUrl(emailReq);
    }

}
