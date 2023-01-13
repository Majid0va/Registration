package com.atl.register.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;

    @NotEmpty(message = "First name can not be empty")
    private String firstName;
    @NotEmpty(message = "Last name can not be empty")
    private String lastName;
    @NotEmpty(message = "Password  can not be empty")
    private String password;
    @NotEmpty(message = "Email not be empty")
    @Email(message = "Please provide valid email")
    private String email;
}
