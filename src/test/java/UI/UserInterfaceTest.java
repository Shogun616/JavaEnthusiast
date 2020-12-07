package UI;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static java.lang.System.setIn;
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

    @Test
    @DisplayName("Testing exit")
    void exit() {
        assertTrue(UserInterface.exit(true, true));
    }

    @Test
    @DisplayName("Testing menu")
    void menu() {
        UserInterface userInterface = new UserInterface();
        assertTrue(userInterface.equals("0") == false);
        assertTrue(userInterface.equals("1") == false);
        assertTrue(userInterface.equals("2") == false);
        assertTrue(userInterface.equals("3") == false);
        assertTrue(userInterface.equals("4") == false);
    }

    @Test
    @DisplayName("Testing InputMismatchException")
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