package com.hanu.fitconnections.service;

import com.hanu.fitconnections.dto.request.UserRegisterRequest;
import com.hanu.fitconnections.enums.Roles;
import com.hanu.fitconnections.mapper.UserMapper;
import com.hanu.fitconnections.model.CustomUserDetails;
import com.hanu.fitconnections.model.Role;
import com.hanu.fitconnections.model.User;
import com.hanu.fitconnections.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
            if(user.isPresent()) return new CustomUserDetails(user.get());
//        User.UserBuilder builder = User.builder();
//        builder.username(username);
//        builder.password(passwordEncoder.encode(username));
//        switch (username) {
//            case "superadmin":
//                builder.roles("SUPERADMIN","ADMIN", "USER");
//                break;
//            case "admin":
//                builder.roles("ADMIN", "USER");
//                break;
//            case "user":
//                builder.roles("USER");
//                break;
//        }
        return null;
    }

}
