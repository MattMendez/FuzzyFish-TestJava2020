package com.challenge.ecommerce.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SqlException extends RuntimeException {

    private String code;

    private HttpStatus status;

    public SqlException() {
        super("SQL error");
        this.code = "400";
        this.status = HttpStatus.BAD_REQUEST;
    }

}