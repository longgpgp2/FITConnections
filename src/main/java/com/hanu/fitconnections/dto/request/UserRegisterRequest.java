package com.hanu.fitconnections.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRegisterRequest {
    private String username;
    private String password;
}
