package com.esanov.librarybackend.request;

public class IdReq {

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
