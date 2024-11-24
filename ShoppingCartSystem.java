package SimplifiedShoppingCartSystem;
import java.util.Scanner;

import static SimplifiedShoppingCartSystem.utils.CartHelpers.*;
import static SimplifiedShoppingCartSystem.utils.ItemHelpers.*;
import static SimplifiedShoppingCartSystem.utils.Basic.*;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        boolean exit = true;
        boolean first_run = true;

        do{
            // If invalid it will return -1
            int first_menu_choice = displayMainMenu(first_run);
            first_run = false;
            
            displaySecondaryMenu(first_menu_choice);

            if(first_menu_choice == 5){
                exit = false;
            }
        }while(exit);
    }

    static int displayMainMenu(boolean is_first_run){
        // Variable to carry the user choice
        int choice = 0;

        // Array of valid options
        int[] validOptions = {1, 2, 3, 4, 5};

        // Display first menu
        if(is_first_run){
            System.out.println("Welcome to SCS");
        }
        System.out.println("1. Create an Item");
        System.out.println("2. Add Item to your Cart");
        System.out.println("3. Remove Item from your Cart");
        System.out.println("4. Show Cart Details");
        System.out.println("5. Exit");
        
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
                createItem();
                break;
            case 2:
                addItemToCart();
                break;
            case 3: 
                removeItemFromCart();
                break;
            case 4:
                showCartDetails();
                break;
            case 5:
                System.exit(1);
            default:
                break;
        }

        return 1;
    }
}