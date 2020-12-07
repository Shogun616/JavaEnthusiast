package Domain;

import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactBook {

    Scanner scan = new Scanner(System.in);
    private  List<Contact> contacts = new ArrayList<>();

    public ContactBook() {
    }

    public List<Contact> getList() {
        printListOfContacts(contacts);
        System.out.println();
        return contacts;
    }

    public void AddContact(String name, String email) {
        contacts.add(new Contact(java.util.UUID.randomUUID().toString(), name, email));
    }

    public void AddContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {

        Contact contactToDelete = null;

        String decision;

        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                contactToDelete = contact;
            }
        }

        if (contactToDelete != null) {
            System.out.println("Contact " + contactToDelete.getName() + " found, would you like to delete? (Y/N)");
            decision = scan.nextLine();
            if (decision.equalsIgnoreCase("N")) {
                System.out.println("Action Canceled");
            } else if (decision.equalsIgnoreCase("Y")) {
                contacts.remove(contactToDelete);
                System.out.println("Contact Deleted");
            }

        } else {
            System.out.println("No Contact Found with '%1$s'%n\", value");
        }
    }

    public void removeContact(Contact contact) {
        removeContact(contact.getName());
    }

    public  void Search(String value) {
        System.out.println(" ");

        List<Contact> result = new ArrayList<>();
        for (Contact x : contacts) {
            if (x.getName().contains(value) || x.getEmail().contains(value)) {
                result.add(x);
            }
        }

        if (!result.isEmpty()) {
            System.out.printf("Found %1$s results!%n", result.size());

            for (Contact contact : result) {
                System.out.printf("ID: %1$s, Name: %2$s, Email: %3$s%n", contact.getId(), contact.getName(), contact.getEmail());
            }
        } else {
            System.out.printf("No contacts found with '%1$s'%n", value);
        }
        System.out.println(" ");
    }

    public final ArrayList<Contact> ConsoleSearch() {

        System.out.println(" ");

        System.out.println("You have opened the console search method");

        System.out.println(" ");

        System.out.print("Enter your search String: ");
        String value = new Scanner(System.in).nextLine();

        ArrayList<Contact> result = (ArrayList<Contact>) contacts.stream().filter(x -> x.getName().contains(value) || x.getEmail().contains(value)).collect(Collectors.toList());

        if (!result.isEmpty()) {
            System.out.printf("Found %1$s results!%n", result.size());

            for (Contact contact : result) {
                System.out.printf("ID: %1$s, Name: %2$s, Email: %3$s%n", contact.getId(), contact.getName(), contact.getEmail());
            }
            System.out.println(" ");
            return result;
        } else {
            System.out.printf("No contacts found with '%1$s'%n", value);
            System.out.println(" ");
            return null;
        }
    }

    public void printListOfContacts(List<Contact> listOfContacts) {
        for (Contact contact : listOfContacts) {
            System.out.println(contact.toString());
        }
    }
}
