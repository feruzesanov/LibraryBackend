package com.esanov.librarybackend.mapper;

import com.esanov.librarybackend.entity.User;
import com.esanov.librarybackend.request.UserAddReq;
import com.esanov.librarybackend.request.UserEditReq;
import com.esanov.librarybackend.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface UserMapper {

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toReq(UserAddReq userAddReq);

    List<UserResponse> toRes(List<User> userList);

    UserResponse toRes(User user);

    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toEntity(@MappingTarget User user , UserEditReq editReq);
}
