package service;

import service.exceptions.InvalidCharacterException;
import service.exceptions.PasswordNotConfirmedException;
import service.exceptions.TooLongFieldException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthService {


    public static void auth(String login, String pswd, String confirm_pswd){
        try {
            validate(login, pswd, confirm_pswd);
        }catch (PasswordNotConfirmedException | InvalidCharacterException | TooLongFieldException e){
            System.err.println(e.getMessage());
        }
    }

    private static void validate(String login, String pswd, String confirm_pswd){

        if (!pswd.equals(confirm_pswd)) throw new PasswordNotConfirmedException("два раза не можешь одинаково вбить пароль, абизян ебучий?!");

        if(login.length()>20 || pswd.length()>20) throw new TooLongFieldException("логин или пароль длинные как моя рука, жаль не всё у меня такое же длинное");

        Pattern pattern = Pattern.compile("[^a-zA-Z0-1_]");
        Matcher loginMissClickSearch = pattern.matcher(login);
        Matcher pswdMissClickSearch = pattern.matcher(pswd);

        if(loginMissClickSearch.find() || pswdMissClickSearch.find()) throw new InvalidCharacterException("в глаза ебешься?! там даны требования к логину и паролю же");
    }

}


