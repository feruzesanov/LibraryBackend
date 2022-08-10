package com.esanov.librarybackend.response;

import com.esanov.librarybackend.enums.Lang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private String name;
    private Integer page;
    private Integer price;
    private Lang lang;
    private String description;

}
