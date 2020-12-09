package Domain;

import Main.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileSavingTest {
    List<Contact> contacts = new ArrayList<>();

    @Test
    @DisplayName("testing saving file call")
    public void testSavingToFile() {
        Contact c = new Contact((java.util.UUID.randomUUID().toString()),
               "Noah", "noah@test.com");
        contacts.add(c);
        assertEquals("Noah", FileSaving.savingToFile(contacts));

        assertEquals(0,FileSaving.class.getDeclaredFields().length);
    }

    @Test
    @DisplayName(" number of constructor")
    public void TestMainClass() throws IOException {
        assertEquals(1, Main.class.getConstructors().length);

    }
}