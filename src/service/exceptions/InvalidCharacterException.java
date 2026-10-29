package service.exceptions;

public class InvalidCharacterException extends RuntimeException{
    public InvalidCharacterException(String message){
        super(message);
    }
}
