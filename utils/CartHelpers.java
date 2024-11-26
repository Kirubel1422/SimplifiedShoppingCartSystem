package SimplifiedShoppingCartSystem.utils;

import static SimplifiedShoppingCartSystem.utils.Basic.displayError;
import static SimplifiedShoppingCartSystem.utils.Basic.printArray;

import java.util.Scanner;

import SimplifiedShoppingCartSystem.modules.Cart.Cart;
import SimplifiedShoppingCartSystem.modules.Product.Item;

public class CartHelpers {
    public static Item[] addItemToCart(Cart myCart, Item item, Item[] incart_items){
        System.out.println(item.getName() + " has been added to your cart successfully.");
        return myCart.addIteminCart(item, incart_items);
    }

    public static int removeItemFromCart(){
        System.out.println("Remove Item from Cart...");
        return 1;
    }

    public static int showCartDetails(){
        System.out.println("Show Cart details...");
        return 1;
    }  
    
    // More general to addItemToCart
    public static void addToCart(Cart cart, Item[] items, Item[] incart_items){
        int itemId;
        printArray(items);

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the item id to add to your cart: ");
        itemId = sc.nextInt();

        int search_result = findItem(items, itemId);
        if(search_result == -1){
            displayError("The item is not found.");
        }else{
            addItemToCart(cart, items[search_result], incart_items);
        }

        sc.close();
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
