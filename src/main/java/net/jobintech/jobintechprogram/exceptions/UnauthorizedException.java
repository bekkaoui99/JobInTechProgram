package net.jobintech.jobintechprogram.exceptions;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message){
       super(message);
    }
}
