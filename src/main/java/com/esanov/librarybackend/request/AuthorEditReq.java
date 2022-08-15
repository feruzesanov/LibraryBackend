package com.esanov.librarybackend.request;


import com.esanov.librarybackend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEditReq extends AuthorAddReq{
    @NotNull(message = "id must not null")
    private Long id;
}
