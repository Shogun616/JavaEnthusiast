package UI;

import Domain.Contact;
import Domain.ContactBook;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {


    static Scanner scan = new Scanner(System.in);
    private static ContactBook contactBook = new ContactBook();
    private static int printCount = 0;
    public static boolean exit(boolean testing, boolean shutdown){

        String decision;
        System.out.println("Exit? (yes/no)");
        if(testing){
            if(shutdown){
                decision = "yes";
            }
            else {
                decision = "no";
            }
        }
        else {
            decision = scan.nextLine();
        }
        if (decision.equalsIgnoreCase("no")) {
            System.out.println("\f");
            menu();
            return false;

        } else if (decision.equalsIgnoreCase("yes")) {

            if(testing){
                System.out.println("Shutting down now");
                System.out.println("This is a test!");
            }
            else {
                System.exit(1);
            }
            return true;
        }
        return false;
    }

    public static int menu(){
        System.out.println("======================");
        System.out.println("      Main Menu       ");
        System.out.println("======================");
        System.out.println("0. Exit");
        System.out.println("1. Add Contact");
        System.out.println("2. Contact List");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete Contact");
        try {
            System.out.println("\nMake your choice");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 0:
                    exit(false, false);
                    break;
                case 1:
                    /* ContactClass
                    break; */
                case 2:
                    /* ContactClass
                    break; */
                case 3:
                    /* ContactClass
                    break; */
                case 4:
                    /* ContactClass
                    break; */
                default:
                    System.out.println("Invalid ");
                    break;
            }
        }
        catch (InputMismatchException ex){
            throw new InputMismatchException(ex + " Invalid command!");
        }
        return 1;
    }

    public void Input(){
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter a number: ");
            int input = scan.nextInt();
            System.out.println(input);
        }
        catch (InputMismatchException ex){
            throw new InputMismatchException("Invalid number");
        }
    }


    private static void add() {
        System.out.println("Please enter name and email of the new user");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("email:");
        String email = scan.nextLine();
        contactBook.AddContact(name, email);
        System.out.println("New contact added successfully!");
        Print();
    }

    public static void deleteContact() {
        System.out.println("Enter name of contact to you want to delete:");
        System.out.println("Name:");
        String name = scan.nextLine();
        contactBook.removeContact(name);
    }

    private static void searchContact() {
        System.out.println("Enter a string to match a contact against: ");
        String matchContact = scan.nextLine();
        contactBook.Search(matchContact);

    }

    private static void Print() {

        printCount++;
        List<Contact> list = contactBook.getList();
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒ Print " + printCount + " ▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("Name" + "\t\t\t\t" + "Email");
        System.out.println("-----------------------------------");
        for (int i = 0; i < list.size(); i++) {
            Contact cc = list.get(i);

            System.out.println(cc.getName() + "\t\t\t\t" + cc.getEmail());

        }

        System.out.println("-----------------------------------");

    }


}
