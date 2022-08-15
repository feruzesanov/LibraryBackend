package com.esanov.librarybackend.request;

import javax.validation.constraints.NotNull;

public class IdReq {

    @NotNull(message = "id must be not null")
    private Long id;

    public IdReq(Long id) {
        this.id = id;
    }

    public IdReq() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
