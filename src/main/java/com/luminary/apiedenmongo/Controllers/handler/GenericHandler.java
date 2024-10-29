package com.luminary.apiedenmongo.Controllers.handler;

import com.luminary.apiedenmongo.Models.Exception.HttpError;
import com.luminary.apiedenmongo.Models.Response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GenericHandler {
    @ExceptionHandler(HttpError.class)
    public ResponseEntity<ErrorResponse> genericHandler(HttpError error) {
        log.error(error.getMessage());
        ErrorResponse response = ErrorResponse.builder()
                .httpStatus(error.getHttpStatus())
                .message(error.getMessage())
                .build();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }
}
