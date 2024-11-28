package modules.Cart;

import modules.Product.*;

public class Cart extends Item
{
    private static float totalPrice;
    static float TAX_RATE = 7;

    //specific attribute
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
                System.out.println("Item removed successfully.");
            } else {
                System.out.println("Item not found in the cart.");
            }
        } else {
            System.out.println("The cart is empty. No item to remove.");
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
            System.out.println("There is no item in the stock");
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
    public int printInCartItems(){
        if(this.inCart == 0){
            return -1;
        }
        
        int[] inCartItemIds = new int[incartItems.length];
        boolean exists = false;

            for(int i=0; i< incartItems.length; i++){
                Item item = incartItems[i];

                if(item != null){
                    for(int index:inCartItemIds){
                        if(index == item.getId()){
                            exists = true;
                        }
                    }
                    if(!exists){
                        inCartItemIds[i] = item.getId();
                        System.out.println("Item Name: " + item.getName() + " , Item Price: " + item.getPrice() + " X " + item.getInCartCount());
                    }
                }
            }
            return 1;
        
    }

    // public void getTotal(){
    //     double total = 0;
    //     for(Item item:incartItems){
    //         if(item!= null){
    //             total += item.getPrice();
    //         }
    //     }

    //     System.out.println("SubTotal: (without tax) " + total);
    //     System.out.println("Total: (" + TaxCalculator.)
    // }
}
