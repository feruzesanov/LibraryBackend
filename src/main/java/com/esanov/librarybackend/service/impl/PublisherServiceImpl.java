package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.entity.Publisher;
import com.esanov.librarybackend.mapper.PublisherMapper;
import com.esanov.librarybackend.repository.PublisherRepository;
import com.esanov.librarybackend.request.PublisherAddReq;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;
    @Override
    public ResponseEntity<ResponseMessage> add(PublisherAddReq publisherAddReq) {
        Publisher publisher = publisherMapper.toReq(publisherAddReq);
        publisherRepository.save(publisher);
        return ResponseEntity.ok(new ResponseMessage("Publisher muvaffaqiyatli qo'shildi."));
    }
}
