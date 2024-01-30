//package com.java.customer.exception;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.Date;
//
//@ControllerAdvice
//public class GlobalException extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<Object> anyException(Exception ex) {
//        String errorMessageDescription = ex.getLocalizedMessage();
//        if (errorMessageDescription == null) {
//            errorMessageDescription = ex.toString();
//        }
//        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
//        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(value = {ErrorMessage.class})
//    public ResponseEntity<Object> errorMessage(ErrorMessage errorMessage){
//
//        return  new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }
//}
