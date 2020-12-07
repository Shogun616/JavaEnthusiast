package UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

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

    @DisplayName("Testing exit")
    @Test
    void exit() {
        assertTrue(UserInterface.exit(true, true));
    }

    @DisplayName("Testing menu")
    @Test
    void menu() {
        UserInterface userInterface = new UserInterface();
        assertTrue(userInterface.equals("0") == false);
        assertTrue(userInterface.equals("1") == false);
        assertTrue(userInterface.equals("2") == false);
        assertTrue(userInterface.equals("3") == false);
        assertTrue(userInterface.equals("4") == false);
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