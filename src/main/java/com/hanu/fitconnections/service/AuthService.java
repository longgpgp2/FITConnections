package com.hanu.fitconnections.service;

import com.hanu.fitconnections.dto.request.UserRegisterRequest;
import com.hanu.fitconnections.mapper.UserMapper;
import com.hanu.fitconnections.model.Role;
import com.hanu.fitconnections.model.User;
import com.hanu.fitconnections.repository.RoleRepository;
import com.hanu.fitconnections.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public void registerUser(UserRegisterRequest registerRequest) {
//        User user = UserMapper.INSTANCE.toUser (registerRequest);
        Optional<Role> role = roleRepository.findById(Long.parseLong("3"));
        User user = new User.UserBuilder()
                .setUsername(registerRequest.getUsername())
                .setPassword(registerRequest.getPassword())
                .setRole(role.get()).build();
        userRepository.save(user);
    }
}
