package com.sample.loginsignup.domain.user.dto;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

@Getter
@Setter
@Builder
public class UserDto {

    protected String id;
    private String username;
    private String password;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonTypeName("user")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
    public static class Registration {

        private String username;
        private String password;

    }


}
