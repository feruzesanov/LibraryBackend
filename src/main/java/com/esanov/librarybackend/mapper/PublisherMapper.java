package com.esanov.librarybackend.mapper;

import com.esanov.librarybackend.entity.Publisher;
import com.esanov.librarybackend.request.PublisherAddReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface PublisherMapper {

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Publisher toReq(PublisherAddReq publisherAddReq);

}
