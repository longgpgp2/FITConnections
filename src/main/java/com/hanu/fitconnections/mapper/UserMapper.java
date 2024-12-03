package com.hanu.fitconnections.mapper;

import com.hanu.fitconnections.dto.request.UserRegisterRequest;
import com.hanu.fitconnections.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "createdAt", expression = "java(new java.util.Date())")
    @Mapping(target = "updatedAt", expression = "java(new java.util.Date())")
    User toUser (UserRegisterRequest userRegisterRequest);
}