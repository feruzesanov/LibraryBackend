package com.esanov.librarybackend.request;

import com.esanov.librarybackend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorAddReq {

    @NotBlank(message = "fullName must not be empty")
    private String fullName;

    @NotNull(message = "birthday must not null")
    private LocalDateTime birthday;

    @NotNull(message = "gender must not null")
    private Gender gender;

    @NotBlank(message = "description must be be empty")
    private String description;
}
