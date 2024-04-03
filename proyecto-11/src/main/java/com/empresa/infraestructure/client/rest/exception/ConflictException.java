package com.empresa.infraestructure.client.rest.exception;

public class ConflictException extends RuntimeException{

    public ConflictException(String detail) {
        super(detail);
    }

}
