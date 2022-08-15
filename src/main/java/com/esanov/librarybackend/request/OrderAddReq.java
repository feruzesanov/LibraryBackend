package com.esanov.librarybackend.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddReq {

    @NotNull(message = "bookId must not null")
    private Long bookId;

    @NotNull(message = "userId must not null")
    private Long userId;

}
