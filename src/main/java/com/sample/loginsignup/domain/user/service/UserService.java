package com.sample.loginsignup.domain.user.service;

import com.sample.loginsignup.domain.user.dto.UserDto;

public interface UserService {

    UserDto registration(final UserDto.Registration registration);

    UserDto login(final UserDto.Login login);
}
