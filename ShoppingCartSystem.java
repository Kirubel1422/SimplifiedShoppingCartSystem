import java.util.Scanner;

import modules.Cart.Cart;
import modules.Product.Item;
import modules.TaxCalculator.TaxCalculator;

import static utils.CartHelpers.*;
import static utils.ItemHelpers.*;
import static utils.Basic.*;
import static utils.TaxHelper.*;

public class ShoppingCartSystem {
    private static Item[] items = new Item[5];
    
    private static Cart myCart = new Cart();

    private static TaxCalculator taxCalculator = new TaxCalculator();

    public static void main(String[] args) {
        boolean exit = true;
        boolean first_run = true;

        do{
            // If invalid it will return -1
            int first_menu_choice = displayMainMenu(first_run);
            first_run = false;
            System.out.println("Choice: " + first_menu_choice);
            displaySecondaryMenu(first_menu_choice);

            if(first_menu_choice == 7){
                exit = false;
            }
        }while(exit);
    }

    static int displayMainMenu(boolean is_first_run){
        // Variable to carry the user choice
        int choice = 0;

        // Array of valid options
        int[] validOptions = {1, 2, 3, 4, 5, 6, 7};

        // Display first menu
        if(is_first_run){
            System.out.println("Welcome to SCS");
        }

        System.out.println("1. Create an Item");
        System.out.println("2. Add Item to your Cart");
        System.out.println("3. Remove Item from your Cart");
        System.out.println("4. Show Cart Details");
        System.out.println("5. List all available Items.");
        System.out.println("6. Change default tax rate.");
        System.out.println("7. Exit");
        
        // Get user choice
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        // Validate user input
        if(validateInput(validOptions, choice)){
            return choice;
        }else{
            return -1;
        }     
    }

    static int displaySecondaryMenu(int firstMenuChoice){
        switch (firstMenuChoice) {
            case 1:
                items = createItem(items);
                break;
            case 2:
                addToCart(myCart, items);
                break;
            case 3: 
                removeItemFromCart(myCart, items);
                break;
            case 4:
                showCartDetails(myCart, taxCalculator);
                break;
            case 5:
                printArray(items);
                break;
            case 6:
                setTax(taxCalculator);
                break;
            case 7:
                System.exit(1);
                break;    
            default:
                break;
        }

        return 1;
    }
}