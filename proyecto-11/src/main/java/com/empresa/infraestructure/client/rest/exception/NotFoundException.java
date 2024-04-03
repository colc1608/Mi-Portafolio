package com.empresa.infraestructure.client.rest.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String detail) {
        super(detail);
    }

}
