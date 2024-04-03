package com.empresa.infraestructure.client.rest.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String detail) {
        super(detail);
    }

}
