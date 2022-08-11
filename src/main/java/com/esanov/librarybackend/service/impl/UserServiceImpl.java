package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.entity.User;
import com.esanov.librarybackend.mapper.UserMapper;
import com.esanov.librarybackend.repository.UserRepository;
import com.esanov.librarybackend.request.EmailReq;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.UserAddReq;
import com.esanov.librarybackend.request.UserEditReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.response.UserResponse;
import com.esanov.librarybackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public ResponseData<ResponseMessage> add(UserAddReq userAddReq) {
        Optional<User> userOptional = userRepository.findByEmail(userAddReq.getEmail());
        if (userOptional.isPresent()) {
            throw new RuntimeException("Bunday emaillik user mavjud");
        }
        if (!userAddReq.getPhone().startsWith("+")) {
            userAddReq.setPhone("+" + userAddReq.getPhone());
        }
        User user = userMapper.toReq(userAddReq);
        userRepository.save(user);
        return new ResponseData<>(new ResponseMessage("User muvaffaqiyatli qo'shildi."));
    }


    @Override
    public ResponseData<List<UserResponse>> getAll(int page, int size) {
        System.out.println("jfsdjf");
        List<User> authorList = userRepository.findAll(PageRequest.of(page, size)).toList();
        return new ResponseData<>(userMapper.toRes(authorList));
    }

    @Override
    public ResponseData<UserResponse> getOne(IdReq idReq) {
        Optional<User> userOptional = userRepository.findById(idReq.getId());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik user yoq");
        }
        return new ResponseData<>(userMapper.toRes(userOptional.get()));
    }

    @Override
    public ResponseData<UserResponse> update(UserEditReq editReq) {
        Optional<User> userOptional = userRepository.findById(editReq.getId());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Bunday idlik user nmavjud emas");
        }
        User user = userMapper.toEntity(userOptional.get(), editReq);
        userRepository.save(user);
        return new ResponseData<>(userMapper.toRes(user));
    }

    @Override
    public ResponseData<Boolean> delete(IdReq idReq) {
        if (!userRepository.existsById(idReq.getId())) {
            throw new RuntimeException("Bunday idlik user yoq");
        }
        userRepository.deleteById(idReq.getId());
        return new ResponseData<>(true);
    }

    @Override
    public ResponseData<List<ResponseMessage>> downloadUrl(EmailReq emailReq) {

        List<ResponseMessage> urlList = new ArrayList<>();
        Long userId = userRepository.userIdByEmail(emailReq.getEmail());
        if (userId != null) {
            List<Long> bookIdList = userRepository.bookIdByUserId(userId);

            if (!bookIdList.isEmpty()) {
                bookIdList.forEach(bookId -> {
                    List<Long> attachmentIdList = userRepository.attachmentIdOrderBookId(bookId);
                    if (!attachmentIdList.isEmpty()) {
                        attachmentIdList.forEach(attachmentId -> {
                            String downloadUrl = userRepository.attachmentUrl(attachmentId);
                            urlList.add(new ResponseMessage(downloadUrl));
                        });
                    }
                });
            }
        }
        return new ResponseData<>(urlList);
    }

}

