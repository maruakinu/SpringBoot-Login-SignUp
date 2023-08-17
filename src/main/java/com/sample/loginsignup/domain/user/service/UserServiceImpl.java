package com.sample.loginsignup.domain.user.service;

import com.sample.loginsignup.domain.exception.AppException;
import com.sample.loginsignup.domain.user.dto.UserDto;
import com.sample.loginsignup.domain.user.entity.UserEntity;
import com.sample.loginsignup.domain.user.repository.UserRepository;
import com.sample.loginsignup.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.loginsignup.domain.exception.Error;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private final JwtUtils jwtUtils;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto registration(UserDto.Registration registration) {
        userRepository.findByUsername(registration.getUsername()).stream().findAny().ifPresent(entity -> {
            throw new AppException(Error.DUPLICATED_USER);
        });
        UserEntity userEntity = UserEntity.builder()
                .username(registration.getUsername())
                .email(registration.getEmail())
                .password(passwordEncoder.encode(registration.getPassword()))
                .build();

        if (registration.getUsername() == "" || registration.getPassword() == "" || registration.getEmail() == ""){
            throw new AppException(Error.FIELD_EMPTY);
        }else{
            userRepository.save(userEntity);
        }

        return convertEntityToDto(userEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto login(UserDto.Login login) {
        UserEntity userEntity = userRepository.findByEmail(login.getEmail()).filter(user -> passwordEncoder.matches(login.getPassword(), user.getPassword())).orElseThrow(() -> new AppException(Error.LOGIN_INFO_INVALID));
        return convertEntityToDto(userEntity);
    }

    private UserDto convertEntityToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .username(userEntity.getUsername())
                .token(jwtUtils.encode(userEntity.getEmail()))
                .build();
    }
}
