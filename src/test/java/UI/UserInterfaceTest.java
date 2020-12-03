package UI;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInterfaceTest {

    @BeforeAll
    public static void init(){
        System.out.println("Before All init() method called");
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("After All cleanUp() method called");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before Each initEach() method called");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each cleanUpEach() method called");
    }

    @DisplayName("Testing options")
    @Test
    void options() {
        UserInterface ui = new UserInterface();

        String input = "add 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("add 1", ui.menu());
    }

    @DisplayName("Testing menu")
    @Test
    void menu() {
        UserInterface ui = new UserInterface();

        assertTrue(true, "ON");
        assertTrue(false, "OFF");
    }

    @DisplayName("Testing InputMismatchException")
    @Test
    void verifyInputMismatchExceptionIsThrown(){

        UserInterface ui = new UserInterface();
        String input = "Invalid input";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () -> {
            ui.options();
        });
    }
}