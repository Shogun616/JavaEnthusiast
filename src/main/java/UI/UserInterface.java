package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    static Scanner scan = new Scanner(System.in);

    public static void options(){
        boolean exit = true;

        while(exit) {
            System.out.print("Enter a command: ");
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("n")) {
                exit = false;
                menu();
            } else if (input.equalsIgnoreCase("y")) {
                exit = false;
            }
        }
    }

    public static void menu(){
        System.out.println("======================");
        System.out.println("      Main Menu       ");
        System.out.println("======================");
        System.out.println("0. Exit");
        System.out.println("1. Add Contact");
        System.out.println("2. Contact List");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete Contact");
        System.out.println("\nMake your choice");
        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice){
            case 0:
                System.out.println("Exit? (Y/N)");
                options();
                System.out.println("Shutting down now!");
                break;
            case 1:
              //  break;
            case 2:
              //  break;
            case 3:
              //  break;
            case 4:
              //  break;
            default:
                System.out.println("Invalid command! Please try again!");
                break;
        }

    }

    public void enterInteger() {
        {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Ange en siffra: ");
                Integer input = scan.nextInt();
                System.out.println(input);
            } catch (InputMismatchException ex) {
                throw new InputMismatchException("Det där är inte en siffra!");
            }
        }
    }

    public static void main(String[] args) {
        boolean waitingForCorrectInput = true;

        while (waitingForCorrectInput) {
            UserInterface ui = new UserInterface();
            try {
                ui.enterInteger();
                waitingForCorrectInput = false;
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}