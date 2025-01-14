package com.ademozalp.bileton.exception;


import com.ademozalp.bileton.dto.base.ErrorResponse;
import com.ademozalp.bileton.exception.type.TripException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TripException.class)
    public ErrorResponse handleTripException(TripException e) {
        return ErrorResponse.builder()
                .message(e.getErrorMessage().message())
                .code(e.getErrorMessage().code())
                .build();
    }
}
