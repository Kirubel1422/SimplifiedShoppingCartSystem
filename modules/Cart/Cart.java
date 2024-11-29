package modules.Cart;

import modules.Product.*;
//subclass of Item 
public class Cart extends Item
{
    private static float totalPrice;
    static float TAX_RATE = 7;

    //creating array of items of class item
    Item[] incartItems = new Item[5];

    private int cartId = 0;
    private int inCart;

    //default constructor
    public Cart(){
        this.cartId++;
        this.inCart = 0;
        this.totalPrice=0;
    }

    //method to remove an item from the cart
    public void removeFromCart(Item itemToBeRemoved) {
        if (inCart > 0) {
            boolean itemFound = false;
            Item[] incartArrayCopy = new Item[incartItems.length];
            int newIndex = 0;

            for (int i = 0; i < incartItems.length; i++) {
                if (incartItems[i] != null && incartItems[i].equals(itemToBeRemoved) && !itemFound) {
                    // Skip the first occurrence of the item to be removed
                    totalPrice -= incartItems[i].getPrice();
                    incartItems[i].inc(); // Increment stock when item is removed
                    inCart--;
                    itemFound = true;
                } else {
                    // Add remaining items to the new array
                    if (newIndex < incartArrayCopy.length) {
                        incartArrayCopy[newIndex++] = incartItems[i];
                    }
                }
            }

            if (itemFound) {
                incartItems = incartArrayCopy;
                System.out.println("Item removed successfully.\n");
                itemToBeRemoved.dec_in_cart_count();
            } else {
                System.out.println("Item not found in the cart.\n");
            }
        } else {
            System.out.println("The cart is empty. No item to remove.\n");
        }
    }

    //method to calculate total price of items
    public float getTotalPrice() {
        return totalPrice;
    }

    //method for adding items
    int i=0;//item array index

    //adding individual item of  Item class
    public void addIteminCart(Item individualItem)
    {
        if(getInStockQuantity() > 0) {
            this.incartItems[i] = individualItem;
            totalPrice += individualItem.getPrice();
            individualItem.dec();
            individualItem.inc_in_cart_count();
            inCart++;
            i++;
        }
        else{
            System.out.println("There is no item in the stock\n");
        }
    }
    
    // return incart items 
    public Item[] getInCartItems(){
        return this.incartItems;
    }

    // get in cart amount
    public int getInCartAmount(){
        return this.inCart;
    }

    // Print in cart items in a good format
    public int printInCartItems() {
        if (this.inCart == 0) {
            return -1;
        }
    
        int[] inCartItemIds = new int[incartItems.length];
        boolean exists = false;
    
        // Print the table header
        System.out.println("--------------------------------------------------");
        System.out.println("| Item Name         | Item Price | Quantity     |");
        System.out.println("--------------------------------------------------");
    
        for (int i = 0; i < incartItems.length; i++) {
            Item item = incartItems[i];
    
            if (item != null) {
                // Check if item is already in the inCartItemIds array
                exists = false;
                for (int index : inCartItemIds) {
                    if (index == item.getId()) {
                        exists = true;
                        break;
                    }
                }
    
                // If the item is not in the array, display it
                if (!exists) {
                    inCartItemIds[i] = item.getId();
    
                    // Print item details in the table
                    String itemName = item.getName();
                    String itemPrice = String.format("%.2f", item.getPrice());
                    int itemQuantity = item.getInCartCount();
                    
                    // Formatting the output to align the columns
                    System.out.printf("| %-18s | %-10s | %-12d |\n", itemName, itemPrice, itemQuantity);
                }
            }
        }
    
        System.out.println("--------------------------------------------------");
        return 1;
    }
    
}
