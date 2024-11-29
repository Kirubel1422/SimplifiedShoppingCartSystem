import java.util.Scanner;
import modules.Cart.Cart;
import modules.Product.Item;
import modules.TaxCalculator.TaxCalculator;
import static utils.Basic.*;
import static utils.CartHelpers.*;
import static utils.ItemHelpers.*;
import static utils.TaxHelper.*;

public class ShoppingCartSystem {

    private static Item[] items = new Item[5];  // Declaring an array for items
    private static Cart myCart = new Cart();  // Creating a cart object
    private static TaxCalculator taxCalculator = new TaxCalculator();  // Creating a tax calculator object

    public static void main(String[] args) {
        int roleChoice = 0;
        Scanner sc = new Scanner(System.in);

        Item item1 = new Item("Ball", 40, 3);
        Item item2 = new Item("Monitor", 300, 3);
        Item item3 = new Item("Torpa Detergent", 40, 3);

        items[0] = item1;
        items[1] = item2;
        items[2] = item3;
        
        boolean shouldContinue = true;  // Flag to control the main loop
        boolean isFirstRun = true;  // Flag to handle the first run

        while (shouldContinue) {

            // Display role selection on the first run
            if (isFirstRun) {
                System.out.println("Welcome to Simplified Shopping Cart.");
                System.out.println("Choose your role:");
                System.out.println("1. Customer");
                System.out.println("2. Vendor");    
                // Get role choice
                System.out.print("Enter role (1 for Customer, 2 for Vendor): ");
    
                
                roleChoice = sc.nextInt();
            }
    
            String userChoice = displayMainMenu(isFirstRun, roleChoice);  // Get user input from the main menu
            isFirstRun = false;  // Reset the first-run flag after the initial iteration

            // Extract role and menu option
            char role = userChoice.charAt(0);
            char menuChoice = userChoice.charAt(2);

            // Process the menu choice
            if (!processSecondaryMenu(menuChoice, role)) {
                shouldContinue = false;  // Stop the loop if user chooses to exit
            }
        }
    }

    static String displayMainMenu(boolean isFirstRun, int roleChoice) {
        Scanner sc = new Scanner(System.in);
    
        // Display menu based on role
        printStarBorder(50);
        if (roleChoice == 1) {
            System.out.println("* 1. List all available Items.                   *");
            System.out.println("* 2. Add Item to your Cart                       *");
            System.out.println("* 3. Remove Item from your Cart                  *");
            System.out.println("* 4. Show Cart Details                           *");
            System.out.println("* 5. Exit                                        *");
        } else if (roleChoice == 2) {
            System.out.println("* 1. Create an Item                              *");
            System.out.println("* 2. List all available Items.                   *");
            System.out.println("* 3. Change default tax rate.                    *");
            System.out.println("* 4. Exit                                        *");
        } else {
            System.out.println("Invalid role choice. Please try again.");
            return displayMainMenu(true, roleChoice);  // Recurse for valid input
        }
        printStarBorder(50);

        // Get menu choice
        System.out.print("Enter your menu choice: ");
        int menuChoice = sc.nextInt();

        // Validate menu choice
        int[] validOptions = (roleChoice == 1) ? new int[]{1, 2, 3, 4, 5} : new int[]{1, 2, 3, 4, 5, 6, 7};
        if (validateInput(validOptions, menuChoice)) {
            return roleChoice + " " + menuChoice;
        } else {
            System.out.println("Invalid menu choice. Please try again.");
            return displayMainMenu(false, roleChoice);  // Recurse for valid input
        }
    }

    static boolean processSecondaryMenu(char menuChoice, char role) {
        int choice = Character.getNumericValue(menuChoice);
        int userRole = Character.getNumericValue(role);

        if (userRole == 1) {  // Customer Menu
            switch (choice) {
                case 1:
                 printArray(items);  // List items
                break;
                 case 2:
                 addToCart(myCart, items);  // Add item to cart
                break;
                 case 3:
                 removeItemFromCart(myCart, items);  // Remove item from cart
                break;
                 case 4:
                 showCartDetails(myCart, taxCalculator);  // Show cart details
                break;
                 case 5:
                 { return false; }  // Exit
                 default:
                 System.out.println("Invalid choice.");
            }
        } else if (userRole == 2) {  // Vendor Menu
            switch (choice) {
                case 1:
                 items = createItem(items);  // Create an item
                 break;
                case 2:
                  printArray(items);
                  break;
                case 3:
                 setTax(taxCalculator);  // Change tax rate
                 break;
                case 4:
                 { return false; }  // Exit
                default:
                 System.out.println("Invalid choice.");
            }
        }
        return true;  // Continue the loop
    }

    // Helper method to print a star border
    static void printStarBorder(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // Validation method for user input
    static boolean validateInput(int[] validOptions, int choice) {
        for (int option : validOptions) {
            if (choice == option) {
                return true;
            }
        }
        return false;
    }
}
