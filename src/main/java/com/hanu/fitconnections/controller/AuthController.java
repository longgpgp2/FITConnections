package com.hanu.fitconnections.controller;

import com.hanu.fitconnections.dto.request.UserLoginRequest;
import com.hanu.fitconnections.dto.request.UserRegisterRequest;
import com.hanu.fitconnections.service.AuthService;
import com.hanu.fitconnections.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Autowired
    AuthService authService;


    @GetMapping("/")
    public ResponseEntity<String> home(){
        return new ResponseEntity<String>("message", HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<String> postRegister(@RequestBody UserRegisterRequest registerRequest){
        UserDetails user = userDetailsService.loadUserByUsername(registerRequest.getUsername());
        if(user!=null) {
            return new ResponseEntity<String>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }
        authService.registerUser(registerRequest);
        return new ResponseEntity<String>("User created successfully", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> getLogin(){
        return new ResponseEntity<String>("Hello, please enter your credentials", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> postLogin(@RequestBody UserLoginRequest loginRequest){
        UserDetails user = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        if(user!=null)
            return new ResponseEntity<String>("You have logged in", HttpStatus.OK);
        else return new ResponseEntity<String>("Invalid credentials", HttpStatus.NOT_ACCEPTABLE);
    }
}
