package com.sample.loginsignup.domain.user.controller;

import com.sample.loginsignup.domain.exception.AppException;
import com.sample.loginsignup.domain.user.dto.UserDto;
import com.sample.loginsignup.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // user registration
    @PostMapping
    public UserDto registration(@RequestBody @Valid UserDto.Registration registration) {
        try {
            return userService.registration(registration);
        }catch (AppException aex) {
            throw new ResponseStatusException(
                    aex.getError().getStatus().value(), aex.getError().getMessage(), aex);
        }
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody @Valid UserDto.Login login) {
        return userService.login(login);
    }



}
