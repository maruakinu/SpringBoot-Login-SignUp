package com.sample.loginsignup.domain.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Builder
    public UserEntity(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }



}
