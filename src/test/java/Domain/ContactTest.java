package Domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    private Contact c;
    @BeforeAll
    static void before(){
        System.out.println("Useless test that runs before all");
    }
    @BeforeEach
    void init (){
        System.out.println("Testing instance of contact ");
        c= new Contact("fre45t", "giorgio solinas", "giorgio.solinas@gmail.com");
    }


    @Test
    @DisplayName("Getter for id")
    void getId() {
        System.out.println("Testing gedId");
        assertEquals("fre45t", c.getId());
    }

    @Test
    @DisplayName("Setter for id")
    void setId() {
        System.out.println("Testing setId");
        c.setId("rt7756d");
        assertEquals("rt7756d",c.getId());
    }

    @Test
    @DisplayName("Getter for name")
    void getName() {
        System.out.println("testing getName");
        assertEquals("giorgio solinas", c.getName());
    }

    @Test
    @DisplayName("Setter for name")
    void setName() {
        System.out.println("Testing setName");
        c.setName("Leo Solinas");
        assertEquals("Leo Solinas", c.getName());
    }

    @Test
    @DisplayName("Getter for email")
    void getEmail() {
        System.out.println("Testing getEmail");
        assertEquals("giorgio.solinas@gmail.com", c.getEmail());
    }

    @Test
    @DisplayName("Setter for email")
    void setEmail() {
        System.out.println("Testing setEmail");
        c.setEmail("leo.solinas1@gmail.com");
        assertEquals("leo.solinas1@gmail.com", c.getEmail());
    }

    @AfterEach
    void afterEachTest(){
        System.out.println("Useless test that runs after each test");
    }
    @AfterAll
    static void after(){
        System.out.println("Useless test that runs after all tests");
    }

}