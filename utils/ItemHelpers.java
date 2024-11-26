package SimplifiedShoppingCartSystem.utils;

import static SimplifiedShoppingCartSystem.utils.Basic.displayError;
import static SimplifiedShoppingCartSystem.utils.Basic.printArray;
import static SimplifiedShoppingCartSystem.utils.Basic.validateInput;

import java.util.Scanner;
import SimplifiedShoppingCartSystem.modules.Product.*;
import SimplifiedShoppingCartSystem.utils.Basic.*;;

public class ItemHelpers {
    public static Item[] createItem(Item[] items){
        Scanner sc = new Scanner(System.in);

        String item_name = "";

        boolean isVisible = false;
        String isVisibleResp = "";
        String[] validOptions = {"yes", "no"};
        
        float price = 0f;

        int inStock = 0;

        System.out.print("Enter item name: ");
        item_name = sc.nextLine();
        
        System.out.print("Enter item price: ");
        price = sc.nextFloat();

        System.out.print("Do you want the item to be visible for customers? [yes/no] ");
        sc.nextLine();
        isVisibleResp = sc.nextLine();

        if(!validateInput(validOptions, isVisibleResp, true)){
            displayError("You can either choose yes or no. ");
            return items;
        }

        System.out.print("Enter quantity of items you have in stock: ");
        inStock = sc.nextInt();
        if(inStock < 1){
            System.out.println("Invalid stock quantity!");
            return items;
        }

        Item item = new Item(item_name, price, isVisible, inStock);
        
        System.out.println(item_name + " successfully added.");
        
        return appendItem(items, item);
    }

    public static Item[] appendItem(Item[] items, Item item_to_be_added){
        int first_empty_index = 0;
        for(Item item : items){
            if(item == null){
                break; 
            }
            first_empty_index++;
        }
        System.out.println("First Empty Index: " + first_empty_index);
        items[first_empty_index]=item_to_be_added;
  
        return items;
    }
}