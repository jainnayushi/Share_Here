import java.util.Scanner;

public class Task01 {

    // Authors: [List of team members with their User IDs]

    public static void main(String[] args) {
        displayWelcomeMessage();
        displayMenu();
        processUserInput();
    }

    public static void displayWelcomeMessage() {
        System.out.println("\nWelcome to Art Prints System");
        System.out.println("Best stop for art prints!\n");
    }

    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. View");
        System.out.println("2. Buy");
        System.out.println("3. Add");
        System.out.println("0. Quit\n");
    }

    public static void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Art Prints Inventory:");
                        break;
                    case 2:
                        System.out.println("Buy Art Print:");
                        break;
                    case 3:
                        System.out.println("Add Art Print:");
                        break;
                    case 0:
                        System.out.println("\nThank you for using Art Prints System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
                if (choice != 0) {
                    displayMenu();
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option.\n");
                scanner.next();
            }
        } while (choice != 0);
        scanner.close();
    }
}