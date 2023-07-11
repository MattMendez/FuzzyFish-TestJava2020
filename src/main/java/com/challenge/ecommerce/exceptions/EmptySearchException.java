package com.challenge.ecommerce.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmptySearchException extends RuntimeException {

    private String code;

    private HttpStatus status;

    public EmptySearchException() {
        super("The search trow 0 results");
        this.code = "204";
        this.status = HttpStatus.NO_CONTENT;
    }
}