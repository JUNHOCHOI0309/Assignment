package com.multi.board.exception;

public class NotFoundException extends AppException{
    public NotFoundException(){
        super();
    }
    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
