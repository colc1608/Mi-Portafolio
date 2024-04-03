package com.empresa.infraestructure.client.rest.exception;

import com.empresa.infraestructure.client.rest.exception.BadRequestException;
import com.empresa.infraestructure.client.rest.exception.ConflictException;
import com.empresa.infraestructure.client.rest.exception.ErrorResponse;
import com.empresa.infraestructure.client.rest.exception.NotFoundException;
import lombok.extern.log4j.Log4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex) {
        return new ResponseEntity<>(
                getErrorResponse(ex, HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({
            BadRequestException.class,
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception ex) {
        return new ResponseEntity<>(
                getErrorResponse(ex, HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({
            ConflictException.class,
            ConstraintViolationException.class
    })
    public ResponseEntity<ErrorResponse> handleConflictException(Exception ex) {
        return new ResponseEntity<>(
                getErrorResponse(ex, HttpStatus.CONFLICT),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleInternalServerErrorException(Exception ex) {
        return new ResponseEntity<>(
                getErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    private ErrorResponse getErrorResponse(Exception ex, HttpStatus httpStatus) {

        String method = ex.getStackTrace().length > 0 ? ex.getStackTrace()[0].getMethodName() : "Not found";
        int line = ex.getStackTrace().length > 0 ? ex.getStackTrace()[0].getLineNumber() : 0;

        return ErrorResponse.builder()
                .clazz(getClassName(ex))
                .message(ex.getMessage())
                .httpStatus(httpStatus.value())
                .type(httpStatus.name())
                .method(method)
                .line(line)
                .build();
    }


    private String getClassName(Exception ex) {
        String className = "Not found";

        try {
            className = Class.forName(ex.getStackTrace()[0].getClassName()).getName();
        } catch (Exception ignored) {

        }

        return className;
    }


}
