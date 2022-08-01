package com.esanov.librarybackend.request;

import com.esanov.librarybackend.enums.Genre;
import com.esanov.librarybackend.enums.Lang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAddReq {

    private String name;

    private Integer page;

    private Genre genre;

    private Lang lang;

    private String description;

    private Integer price;

    private Long authorId;

    private LocalDateTime publishDay;

    private Long publisherId;

    private Long attachmentId;

}
