package com.luminary.apiedenmongo.Models.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private final HttpStatus httpStatus;
    private final String message;
}
