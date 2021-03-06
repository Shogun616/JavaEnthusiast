package Domain;

import java.io.Serializable;

public class Contact implements Serializable {

    private String id;
    private String name;
    private String email;

    public Contact(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Contact() {};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
