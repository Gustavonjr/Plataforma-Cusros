package com.ead.authuser.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // Anotação para não levar para o endpoint campos que forem nulos
public class UserDto {

    public interface userView{
        public static interface RegistrationPost{}
        public static interface UserPut{}
        public static interface PasswordPut{}
        public static interface ImagePut{}
    }

    private UUID userId;
    @JsonView(userView.RegistrationPost.class)
    private String username;
    @JsonView(userView.RegistrationPost.class)
    private String email;

    @JsonView({userView.RegistrationPost.class, userView.PasswordPut.class})
    private String password;
    @JsonView(userView.PasswordPut.class)
    private String oldPassword;

    @JsonView({userView.RegistrationPost.class, userView.UserPut.class})
    private String fullName;
    @JsonView({userView.RegistrationPost.class, userView.UserPut.class})
    private String phoneNumber;
    @JsonView({userView.RegistrationPost.class, userView.UserPut.class})
    private String cpf;

    @JsonView(userView.ImagePut.class)
    private String imageUrl;

}
