package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    static Scanner scan = new Scanner(System.in);

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
        if (decision.equalsIgnoreCase("N")) {
            System.out.println("\f");
            menu();
            return false;

        } else if (decision.equalsIgnoreCase("Y")) {

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
}