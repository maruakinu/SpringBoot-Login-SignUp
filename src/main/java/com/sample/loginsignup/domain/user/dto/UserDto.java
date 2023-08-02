package com.sample.loginsignup.domain.user.dto;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    protected String id;

    @NotEmpty(message = "Username should not be empty")
    private String username;
    @NotEmpty(message = "Password should not be empty")
    private String password;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonTypeName("user")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
    public static class Registration {

        @NotEmpty(message = "Username should not be empty")
        private String username;
        @NotEmpty(message = "Password should not be empty")
        private String password;

    }


}
