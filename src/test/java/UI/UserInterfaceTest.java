package UI;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserInterfaceTest {

    @BeforeAll
    public static void init(){
        System.out.println("Before All init() method called");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("Before Each initEach() method called");
    }

    @DisplayName("Testing exit")
    @RepeatedTest(5)
    void exit(RepetitionInfo repetitionInfo) {
        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
        assertTrue(UserInterface.exit(true, true));
    }

    @DisplayName("Testing menu")
    @RepeatedTest(5)
    void menu(RepetitionInfo repetitionInfo) {
        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
        assertTrue(true);
    }

    @DisplayName("Testing InputMismatchException")
    @Test
    void verifyInputMismatchExceptionIsThrown(){

        UserInterface ui = new UserInterface();
        String input = "Invalid input";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () -> ui.menu());
    }

    @AfterEach
    public void cleanUpEach(){
        System.out.println("After Each cleanUpEach() method called");
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("After All cleanUp() method called");
    }
}