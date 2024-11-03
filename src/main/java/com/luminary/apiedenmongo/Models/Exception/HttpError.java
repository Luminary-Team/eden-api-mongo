package com.luminary.apiedenmongo.Models.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class HttpError extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;
}
