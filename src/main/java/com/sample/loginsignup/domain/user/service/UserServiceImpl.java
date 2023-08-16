package com.sample.loginsignup.domain.user.service;

import com.sample.loginsignup.domain.exception.AppException;
import com.sample.loginsignup.domain.user.dto.UserDto;
import com.sample.loginsignup.domain.user.entity.UserEntity;
import com.sample.loginsignup.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.loginsignup.domain.exception.Error;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto registration(UserDto.Registration registration) {
        userRepository.findByUsername(registration.getUsername()).stream().findAny().ifPresent(entity -> {
            throw new AppException(Error.DUPLICATED_USER);
        });
        UserEntity userEntity = UserEntity.builder()
                .username(registration.getUsername())
                .password(passwordEncoder.encode(registration.getPassword()))
                .build();

        if (registration.getUsername() == "" || registration.getPassword() == ""){
            throw new AppException(Error.FIELD_EMPTY);
        }else{
            userRepository.save(userEntity);
        }

        return convertEntityToDto(userEntity);
    }

    @Override
    public UserDto login(UserDto.Login login) {
        return null;
    }

    private UserDto convertEntityToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .password(userEntity.getPassword())
                .username(userEntity.getUsername())
                .build();
    }
}
