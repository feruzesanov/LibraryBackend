package com.esanov.librarybackend.service.impl;

import com.esanov.librarybackend.base.ResponseData;
import com.esanov.librarybackend.entity.Publisher;
import com.esanov.librarybackend.mapper.PublisherMapper;
import com.esanov.librarybackend.repository.PublisherRepository;
import com.esanov.librarybackend.request.IdReq;
import com.esanov.librarybackend.request.PublishEditReq;
import com.esanov.librarybackend.request.PublisherAddReq;
import com.esanov.librarybackend.response.PublishResponse;
import com.esanov.librarybackend.response.ResponseMessage;
import com.esanov.librarybackend.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public ResponseData<ResponseMessage> add(PublisherAddReq publisherAddReq) {
        Publisher publisher = publisherMapper.toReq(publisherAddReq);
        publisherRepository.save(publisher);
        return new ResponseData<>(new ResponseMessage("Publisher muvaffaqiyatli qo'shildi."));
    }

    @Override
    public ResponseData<List<PublishResponse>> getAll(int page, int size) {
        List<Publisher> publisherList = publisherRepository.findAll(PageRequest.of(page, size)).toList();
        return new ResponseData<>(publisherMapper.toRes(publisherList));
    }

    @Override
    public ResponseData<PublishResponse> getOne(IdReq idReq) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(idReq.getId());
        if (publisherOptional.isEmpty()){
            throw new RuntimeException("Bunday idlik publisher yoq");
        }
        return new ResponseData<>(publisherMapper.toRes(publisherOptional.get()));
    }

    @Override
    public ResponseData<PublishResponse> update(PublishEditReq editReq) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(editReq.getId());
        if (publisherOptional.isEmpty()){
            throw new RuntimeException("Bunday idlik pulisher yoq");
        }
        Publisher publisher = publisherOptional.get();
        Publisher publisher1 = publisherMapper.toEditReq(publisher,editReq);
        publisherRepository.save(publisher1);
        return new ResponseData<>(publisherMapper.toRes(publisher1));
    }

    @Override
    public ResponseData<Boolean> delete(IdReq idReq) {
        if (!publisherRepository.existsById(idReq.getId())){
            throw new RuntimeException("Bunday idlik publisher yoq");
        }
        publisherRepository.deleteById(idReq.getId());
        return new ResponseData<>(true);
    }
}
