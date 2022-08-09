package com.esanov.librarybackend.request;

import com.esanov.librarybackend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorAddReq {

    private String fullName;
    private LocalDateTime birthday;
    private Gender gender;
    private String description;
}
