package service.exceptions;

public class TooLongFieldException extends RuntimeException{
    public TooLongFieldException(String message){
        super(message);
    }
}
