package utils;

import static utils.Basic.displayError;
import static utils.Basic.printArray;

import java.util.Scanner;

import modules.Cart.Cart;
import modules.Product.Item;

public class CartHelpers {
    public static void addItemToCart(Cart myCart, Item item){
        try {
            myCart.addIteminCart(item);;
            System.out.println(item.getName() + " has been added to your cart successfully.");
        } catch (Exception e) {
            displayError();
        }
    }

    public static int removeItemFromCart(Cart cart, Item[] items){
        int itemId;
        printArray(cart.getInCartItems());

        // Check if the cart got something before asking for user input
        if(cart.getInCartAmount() == 0){
            System.out.println("Cart is already empty.");
            return -1;
        }

        // Proceed with getting item to remove from cart
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the item id to remove from your cart: ");
        itemId = sc.nextInt();

        int search_result = findItem(items, itemId);
        if(search_result == -1){
            displayError("The item is not found.");
        }else{
            cart.removeFromCart(items[search_result]);
        }
        return 1;
    }

    public static int showCartDetails(Cart myCart){
        Item[] items =  myCart.getInCartItems();

        for(Item item:items){
            if(item != null){
                printArray(items);
                System.out.println("Sub total: " + myCart.getTotalPrice());
                return 1;
            }
        }

        System.out.println("Oops, there is no item in your cart.");
        return -1;
    }  
    
    // More general to addItemToCart
    public static void addToCart(Cart cart, Item[] items){
        int itemId;
        printArray(items);

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the item id to add to your cart: ");
        itemId = sc.nextInt();

        int search_result = findItem(items, itemId);
        if(search_result == -1){
            displayError("The item is not found.");
        }else{
            addItemToCart(cart, items[search_result]);
        }
    }

    // Find an item by id
    public static int findItem(Item[] items, int id){
        int itemIndex = 0;

        for(Item item : items){
            if(item.getId() == id){
                return itemIndex;
            }

            itemIndex++;
        }

        return -1;
    }
}
