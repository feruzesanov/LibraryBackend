package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.entity.User;
import com.esanov.librarybackend.mapper.UserMapper;
import com.esanov.librarybackend.repository.UserRepository;
import com.esanov.librarybackend.request.UserAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public ResponseEntity<ResponseMessage> add(UserAddReq userAddReq) {
        Optional<User> userOptional = userRepository.findByEmail(userAddReq.getEmail());
        if (userOptional.isPresent()){
            throw new RuntimeException("Bunday emaillik user mavjud");
        }
        User user = userMapper.toReq(userAddReq);
        userRepository.save(user);
        return ResponseEntity.ok(new ResponseMessage("User muvaffaqiyatli qo'shildi."));
    }
}
