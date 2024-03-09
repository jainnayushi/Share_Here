import java.util.ArrayList;
import java.util.Scanner;

public class Task02 {

    // Authors: [List of team members with their User IDs]

    private static ArrayList<ArtPrint> artPrintsList = new ArrayList<>();

    public static void main(String[] args) {
        loadData();
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
                System.out.println();
                switch (choice) {
                    case 1:
                        viewArtPrints();
                        break;
                    case 2:
                        buyArtPrint();
                        break;
                    case 3:
                        addArtPrint();
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

    public static void loadData() {
        artPrintsList.add(new ArtPrint(1000001, "Riverbank in springtime", "Van Gogh", "Acrylic", 50.00, 3));
        artPrintsList.add(new ArtPrint(2000002, "Poppy field", "Monet", "Canvas", 25.50, 1));
        artPrintsList.add(new ArtPrint(2000003, "Bridge over a pond of water lilies", "Monet", "Gloss Card", 39.99, 2));
        artPrintsList.add(new ArtPrint(5000444, "Church in Cassone", "Klimt", "Matt 250gsm Paper", 109.99, 0));
        artPrintsList.add(new ArtPrint(9876543, "The Fighting Temeraire", "Turner", "Canvas", 50.50, 2));
    }

    public static void viewArtPrints() {
        System.out.println("Art Prints Inventory:");
        displayData();
        System.out.println();
    }

    public static void displayData() {
        System.out.printf("%-15s%-40s%-20s%-15s%-10s%n", "Item Number", "Title", "Artist", "Price", "Stock");
        int itemNumber = 1;
        for (ArtPrint artPrint : artPrintsList) {
            System.out.printf("%-15d%-40s%-20s%-15s%-10d%n", itemNumber++, artPrint.getTitle(), artPrint.getArtist(),
                    formatPrice(artPrint.getPrice()), artPrint.getStock());
        }
    }

    public static void buyArtPrint() {
        System.out.println("Buy Art Print:");
        displayData();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the item number of the art print you wish to buy (or press 0 to exit): ");
        int itemNumber = scanner.nextInt();
        if (itemNumber >= 1 && itemNumber <= artPrintsList.size()) {
            ArtPrint selectedArtPrint = artPrintsList.get(itemNumber - 1);
            if (selectedArtPrint.getStock() > 0) {
                selectedArtPrint.setStock(selectedArtPrint.getStock() - 1);
                System.out.println("\nYou have successfully bought the following art print:");
                System.out.println("Title: " + selectedArtPrint.getTitle());
                System.out.println("Artist: " + selectedArtPrint.getArtist());
                System.out.println("Price: " + formatPrice(selectedArtPrint.getPrice()));
                System.out.println("Stock: " + selectedArtPrint.getStock());
                System.out.println();
            } else {
                System.out.println("Sorry, this art print is out of stock.");
            }
        } else if (itemNumber == 0) {
            System.out.println("Exiting buy operation.");
        } else {
            System.out.println("Invalid item number. Please enter a valid item number.");
        }
    }

    public static void addArtPrint() {
        System.out.println("Add Art Print:");
        displayData();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item number of the art print you wish to add to (or press 0 to exit): ");
        int itemNumber = scanner.nextInt();
        if (itemNumber >= 1 && itemNumber <= artPrintsList.size()) {
            ArtPrint selectedArtPrint = artPrintsList.get(itemNumber - 1);
            selectedArtPrint.setStock(selectedArtPrint.getStock() + 1);
            System.out.println("You have successfully added one item to the stock of the following art print:");
            System.out.println("Title: " + selectedArtPrint.getTitle());
            System.out.println("Artist: " + selectedArtPrint.getArtist());
            System.out.println("Price: " + formatPrice(selectedArtPrint.getPrice()));
            System.out.println("New Stock: " + selectedArtPrint.getStock());
        } else if (itemNumber == 0) {
            System.out.println("Exiting add operation.");
        } else {
            System.out.println("Invalid item number. Please enter a valid item number.");
        }
    }

    public static String formatPrice(double price) {
        return "£ " + String.format("%.2f", price);
    }
}

class ArtPrint {
    private int id;
    private String title;
    private String artist;
    private String material;
    private double price;
    private int stock;

    public ArtPrint(int id, String title, String artist, String material, double price, int stock) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.material = material;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}