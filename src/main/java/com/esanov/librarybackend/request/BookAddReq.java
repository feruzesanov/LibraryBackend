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

    @NotBlank
    private String name;

    @NotNull
    private Integer page;

    @NotNull
    private Genre genre;

    @NotNull
    private Lang lang;

    @NotBlank
    private String description;

    @NotNull
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
