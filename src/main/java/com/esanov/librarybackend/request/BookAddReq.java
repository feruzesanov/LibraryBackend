package com.esanov.librarybackend.request;

import com.esanov.librarybackend.enums.Genre;
import com.esanov.librarybackend.enums.Lang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAddReq {

    @NotBlank(message = "book name must not be empty")
    private String name;

    @NotNull(message = "page must not null")
    private Integer page;

    @NotNull(message = "genre must not null")
    private Genre genre;

    @NotNull(message = "lang must not null")
    private Lang lang;

    @NotBlank(message = "description must be empty")
    private String description;

    @NotNull(message = "price must not null")
    private Integer price;

    @NotNull
    private Long authorId;

    @NotNull
    private LocalDateTime publishDay;

    @NotNull
    private Long publisherId;

    @NotNull
    private Long attachmentId;

}
