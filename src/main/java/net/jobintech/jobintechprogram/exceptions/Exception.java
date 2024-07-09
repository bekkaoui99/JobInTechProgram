package net.jobintech.jobintechprogram.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class Exception {


    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorBody> handleUnauthorizedException(UnauthorizedException exception){
        String status = "Unauthorized";
        Date time = new Date();
        String message = exception.getMessage();
        ErrorBody errorBody = new ErrorBody(status,time.toString(),message);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorBody> handleNotFoundException(ResourceNotFoundException exception){
        String status = "RecordNotFound";
        Date time = new Date();
        String message = exception.getMessage();
        ErrorBody errorBody = new ErrorBody(status,time.toString(),message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorBody> handleAlreadyExistsException(AlreadyExistsException exception){
        String status = "Already Exists";
        Date time = new Date();
        String message = exception.getMessage();
        ErrorBody errorBody = new ErrorBody(status,time.toString(),message);
        return ResponseEntity.status(HttpStatus.FOUND).body(errorBody);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorBody> handleBadRequestException(BadRequestException exception){
        String status = "Ce Champ Required";
        Date time = new Date();
        String message = exception.getMessage();
        ErrorBody errorBody = new ErrorBody(status,time.toString(),message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

}
