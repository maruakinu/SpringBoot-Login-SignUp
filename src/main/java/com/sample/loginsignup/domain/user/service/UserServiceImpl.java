package com.sample.loginsignup.domain.user.service;

import com.sample.loginsignup.domain.user.dto.UserDto;
import com.sample.loginsignup.domain.user.entity.UserEntity;
import com.sample.loginsignup.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto registration(UserDto.Registration registration) {

        UserEntity userEntity = UserEntity.builder()
                .username(registration.getUsername())
                .password(registration.getPassword())
                .build();

        userRepository.save(userEntity);

        return convertEntityToDto(userEntity);
    }

    private UserDto convertEntityToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .password(userEntity.getPassword())
                .username(userEntity.getUsername())
                .build();
    }
}
