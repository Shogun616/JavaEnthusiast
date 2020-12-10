package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    Contact c= new Contact("fre45t", "giorgio solinas", "giorgio.solinas@gmail.com");

    @Test
    void getId() {
        assertEquals("fre45t", c.getId());
    }

    @Test
    void setId() {
        c.setId("rt7756dg");
        assertEquals("rt7756dg",c.getId());
    }

    @Test
    void getName() {
        assertEquals("giorgio solinas", c.getName());
    }

    @Test
    void setName() {
        c.setName("Leo Solinas");
        assertEquals("Leo Solinas", c.getName());
    }

    @Test
    void getEmail() {
        assertEquals("giorgio.solinas@gmail.com", c.getEmail());
    }

    @Test
    void setEmail() {
        c.setEmail("leo.solinas@gmail.com");
        assertEquals("leo.solinas@gmail.com", c.getEmail());
    }

}