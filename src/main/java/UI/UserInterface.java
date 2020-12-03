package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    static Scanner scan = new Scanner(System.in);

    public void options(){
        {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter command: ");
                Integer input = scanner.nextInt();
                System.out.println(input);
                menu();
            } catch (InputMismatchException ex) {
                throw new InputMismatchException("Invalid command! Please try again!");
            }
        }
    }

    public int menu(){
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
                menu();
                break;
        }
        return choice;
    }

    public static void main(String[] args) {

        boolean waitingForCorrectInput = true;

        while (waitingForCorrectInput) {
            UserInterface ui = new UserInterface();
            try {
                ui.options();
                waitingForCorrectInput = false;
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}