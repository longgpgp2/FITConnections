package com.hanu.fitconnections.repository;

import com.hanu.fitconnections.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findById(Long id);
    public Optional<User> findByUsername(String username);
}
