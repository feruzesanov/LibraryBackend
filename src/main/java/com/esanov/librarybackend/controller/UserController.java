package com.esanov.librarybackend.controller;

import com.esanov.librarybackend.base.BaseURI;
import com.esanov.librarybackend.request.UserAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.esanov.librarybackend.base.BaseURI.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PATH+USER)
public class UserController {
    private final UserService userService;

    @PostMapping(ADD)
    public ResponseEntity<ResponseMessage> add(@RequestBody UserAddReq userAddReq){
        return userService.add(userAddReq);
    }

}
