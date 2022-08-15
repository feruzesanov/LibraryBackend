package com.esanov.librarybackend.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishResponse {
    private Long id;
    private String name;
    private String street;
    private String country;
    private String house;
    private String description;

}
