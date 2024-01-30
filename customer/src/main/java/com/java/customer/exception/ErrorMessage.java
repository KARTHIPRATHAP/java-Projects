package com.java.customer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage extends Exception {
    Date date;
    String message;


    public ErrorMessage(String message) {
        super(message);
    }
}
