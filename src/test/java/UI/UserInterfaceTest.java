package UI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInterfaceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Testing options")
    @Test
    void options() {
    }

    @DisplayName("Testing menu")
    @Test
    void menu() {
    }

    @Test
    void verifyInputMismatchExceptionIsThrown(){

        UserInterface ui = new UserInterface();
        String input = "Invalid input";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () -> {
            ui.enterInteger();
        });
    }
}