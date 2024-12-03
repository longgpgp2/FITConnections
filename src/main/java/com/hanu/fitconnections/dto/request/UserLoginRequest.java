package com.hanu.fitconnections.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserLoginRequest {
    private String username;
    private String password;
}
