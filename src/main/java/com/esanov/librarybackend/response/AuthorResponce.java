package com.esanov.librarybackend.response;

import com.esanov.librarybackend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponce {

    private Long id;
    private String fullName;
    private LocalDateTime birthday;
    private Gender gender;
    private String description;
}
