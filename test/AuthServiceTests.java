import org.junit.jupiter.api.Test;
import service.AuthService;
import service.TaskSalvationService;
import service.exceptions.TooLongFieldException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AuthServiceTests {
    @Test
    void test228(){
        AuthService.auth("12345678900987654321228","123","123");
        AuthService.auth("123","12345678900987654321228","12345678900987654321228");
        AuthService.auth("@@","12345678","12345678");
        AuthService.auth("12345678","@@","@@");
        AuthService.auth("12345678","123","1234");
        AuthService.auth("1234","123","123");


    }

}
