package com.esanov.librarybackend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAddReq {

    @NotBlank(message = "name cannot be empty ")
    private String name;

    @NotBlank(message = "phone cannot be null")
    private String phone;

    @Email(message = "Error in email, please try again")
    private String email;

}
