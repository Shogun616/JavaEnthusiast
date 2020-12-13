package Domain;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileSaving {
    static File file = new File("contacts.txt");
    static boolean exist= file.exists();

    public static String savingToFile(List<Contact> contact) {
        ContactBook contactBook = new ContactBook();
        List<Contact> contacts = new ArrayList<>();
        contacts = contact;
        System.out.println("printing list");
        for (Contact con : contacts)
            System.out.println(con);

        try {
            addContactsToFIle(contacts, file);
        } catch (FileNotFoundException e) {
            System.out.println("file is not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contact.get(0).getName();

    }

    public static void addContactsToFIle(List<Contact> contact, File filename) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (int i = 0; i < contact.size(); i++) {

            if (contact.get(i) != null) {
                objectOutputStream.writeObject(contact.get(i).toString());
                System.out.println("\n");
                System.out.println("contact successfully add to file");
            } else
                System.out.println("null value can not be saved to file");


        }
    }
}
