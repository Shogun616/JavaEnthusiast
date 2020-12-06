package UI;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

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
    @Test
    void exit() {
        assertTrue(UserInterface.exit(true, true));
    }

    @DisplayName("Testing menu")
    @Test
    void menu() {
        String input = "bad input";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class, () -> {
            UserInterface.menu();
        });
    }

    @DisplayName("Testing InputMismatchException")
    @Test
    void verifyInputMismatchExceptionIsThrown() {

        String input = "bad input";

        // Här fejkar vi användarinput genom att ändra inputstream från konsolen till variabeln input ovan
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            UserInterface.readInteger();
        });

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