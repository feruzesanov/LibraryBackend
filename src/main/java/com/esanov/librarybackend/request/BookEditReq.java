package com.esanov.librarybackend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEditReq extends BookAddReq{

    @NotNull(message = "id must not null")
    private Long id;

}
