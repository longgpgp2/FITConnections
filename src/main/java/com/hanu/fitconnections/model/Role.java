package com.hanu.fitconnections.model;

import com.hanu.fitconnections.enums.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Role {
    @Id
    Long id;
    String[] roles;

    public Role(Long id, String[] roles) {
        this.id = id;
        this.roles = roles;
    }
}
