package Domain;

import org.junit.jupiter.api.*;
import Domain.Contact;
import Domain.ContactBook;
import UI.UserInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ContactBookTest {

//private ContactBook contactBook;

    @BeforeAll
    public static void init() {
        System.out.println("Before All init() method called");
    }

    @BeforeEach
    public void initEach() {
        System.out.println("Before Each initEach() method called");

        //contactBook = new ContactBook();
    }

    @Test
    @DisplayName("Testing addContact")
    void addContactDemo() {
        ContactBook contactBook = new ContactBook();
        Contact contact1 = new Contact(java.util.UUID.randomUUID().toString(), "Philip", "philip@mail.com");
        contactBook.AddContact(contact1);
        assertEquals("Philip", contactBook.getList().get(0).getName());
    }

    @Test
    @DisplayName("Testing addContact")
    void addContactsAndVerify() {
        ContactBook contactBook = new ContactBook();

        Contact contact1 = new Contact(java.util.UUID.randomUUID().toString(), "Philip", "philip@mail.com");
        Contact contact2 = new Contact(java.util.UUID.randomUUID().toString(), "Samir", "samir@mail.com");
        Contact contact3 = new Contact(java.util.UUID.randomUUID().toString(), "Adam", "adam@mail.com");
        Contact contact4 = new Contact(java.util.UUID.randomUUID().toString(), "Sara", "sara@mail.com");
        Contact contact5 = new Contact(java.util.UUID.randomUUID().toString(), "Jessica", "jessica@mail.com");

        contactBook.AddContact(contact1);
        contactBook.AddContact(contact2);
        contactBook.AddContact(contact3);
        contactBook.AddContact(contact4);
        contactBook.AddContact(contact5);
        contactBook.AddContact("Sven", "sven@mail.com");

        List<Contact> addedContacts = new ArrayList<>();
        addedContacts.add(contact1);
        addedContacts.add(contact2);
        addedContacts.add(contact3);
        addedContacts.add(contact4);
        addedContacts.add(contact5);
        addedContacts.add(contactBook.getList().get(5));

        List<Contact> foundContacts = contactBook.getList();

        assertEquals(addedContacts, foundContacts);
    }

    @Test
    @DisplayName("Testing removeContact")
    void deleteContact_thenVerifyIsDeleted1() {
        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        setIn(in);
        ContactBook contactBook = new ContactBook();
        contactBook.AddContact("Sam", "sam@mail.com");
        contactBook.AddContact("Sammy", "sammy@mail.com");

        contactBook.removeContact("Sam");

        List<Contact> foundContacts = contactBook.getList();

        assertEquals(1, foundContacts.size());
    }

    @Test
    @DisplayName("Testing searchContact")
    void verifySearchContact() throws Exception {

        ContactBook contactBook = new ContactBook();
        contactBook.AddContact("Kalle", "kalle@ankeborg.com");
        contactBook.AddContact("Kalleos", "kalleos@ankerborg.com");
        contactBook.AddContact("Kajsa", "kajsa@ankeborg.com");
        contactBook.AddContact("Klarabella", "klarabella@ankeborg.com");
        contactBook.AddContact("Annika", "annika@mailson.com");

        PrintStream oldOut = System.out;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        contactBook.Search("Kalle");
        String actualOutput = new String(os.toByteArray());
        System.setOut(oldOut);
        assertTrue(actualOutput.contains("Kalle"));

        System.out.println(actualOutput);
    }


    @AfterEach
    public void cleanUpEach() {
        System.out.println("After Each cleanUpEach() method called");

        //contactBook=null;
    }

    @AfterAll
    public static void cleanUp() {
        System.out.println("After All cleanUp() method called");
    }
}
