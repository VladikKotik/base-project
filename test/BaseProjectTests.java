import org.junit.jupiter.api.Test;
import service.TaskSalvationService;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BaseProjectTests {
    @Test
    void taskExampleTest(){
        assertEquals("t@eb eht av$J!123", TaskSalvationService.reverseLetter("J@va the be$t!123"));
    }


    @Test
    void testEmptyString(){
        assertEquals("",TaskSalvationService.reverseLetter(""));
    }


    @Test
    void testNullString(){
        assertEquals("",TaskSalvationService.reverseLetter(null));
    }

    @Test
    void testNoLettersString(){
        assertEquals("123 !@#",TaskSalvationService.reverseLetter("123 !@#"));
    }


    @Test
    void testOneLetterString(){
        assertEquals("a",TaskSalvationService.reverseLetter("a"));
    }


    @Test
    void testOnlyLettersString(){
        assertEquals("dcba",TaskSalvationService.reverseLetter("abcd"));
    }

    @Test
    void testNonLetterEndAndBeggining(){
        assertEquals("@!jopahui@@!@",TaskSalvationService.reverseLetter("@!iuhapoj@@!@"));
    }


    @Test
    void testCapitalLetter(){
        assertEquals("Java",TaskSalvationService.reverseLetter("avaJ"));
    }
}
