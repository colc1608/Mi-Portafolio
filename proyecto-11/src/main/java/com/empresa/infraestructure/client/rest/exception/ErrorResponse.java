package com.empresa.infraestructure.client.rest.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private int httpStatus;

    private String type, message, clazz, method;

    private int line;

}
