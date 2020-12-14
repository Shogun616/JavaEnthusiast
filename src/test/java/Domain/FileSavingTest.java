package Domain;

import Main.Main;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileSavingTest {
   static List<Contact> contacts;

    @Test
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test is starting");
        contacts = new ArrayList<>();
    }

    @Test
    @DisplayName("testing saving file call")
    public void testSavingToFile() {
        Contact c = new Contact((java.util.UUID.randomUUID().toString()),
               "Noah", "noah@test.com");
        contacts.add(c);
        assertEquals("Noah", FileSaving.savingToFile(contacts));

        assertEquals(2,FileSaving.class.getDeclaredFields().length);
    }

    @Test
    @DisplayName(" number of constructor")
    public void TestMainClass() throws IOException {
        assertEquals(1, Main.class.getConstructors().length);

    }
    @Test
    @DisplayName("test if file exist")
    public void testIfFileExist(){
        File file=new File("contacts.txt");
        assertTrue(FileSaving.exist);
        assertEquals(file,FileSaving.file);
    }
    @Test
    @AfterAll
    public static void afterAll(){
        System.out.println("Test is completed");

    }

}