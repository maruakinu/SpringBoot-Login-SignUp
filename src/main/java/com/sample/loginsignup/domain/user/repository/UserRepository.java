package com.sample.loginsignup.domain.user.repository;

import com.sample.loginsignup.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {


    Optional<UserEntity> findByUsername(String username);

}
