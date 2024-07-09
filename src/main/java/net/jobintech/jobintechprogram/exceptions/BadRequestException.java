package net.jobintech.jobintechprogram.exceptions;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String message){
        super(message);
    }
}
