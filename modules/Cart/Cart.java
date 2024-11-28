package modules.Cart;

import static utils.Basic.printArray;

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
            inCart++;
            i++;
        }
        else{
            System.out.println("There is no item in the stock");
        }
    }
    
    // Useful method to print in cart items
    public void printInCartItems(){
        Item[] inCartItemsCpy = new Item[incartItems.length];
        int[] item_count = new int[incartItems.length];
        int[] added_items_id = new int[incartItems.length];

        int added_counter = 0;
        for(int i=0; i<inCartItemsCpy.length; i++){
            if(this.incartItems[i] != null){
                if(!alreadyInCart(added_items_id, this.incartItems[i].getId())){
                    inCartItemsCpy[added_counter] = this.incartItems[i];
                    added_items_id[added_counter] = this.incartItems[i].getId();
                    item_count[added_counter] = 1;
                    added_counter++;
                }else{
                    item_count[added_counter] = item_count[added_counter] != 0 ? item_count[added_counter] ++ : 1;
                    added_counter++;
                }
        
            }
        }

        for(int i = 0; i < inCartItemsCpy.length; i++){
            if(inCartItemsCpy[i]!=null){
                System.out.println("Item Name: " + inCartItemsCpy[i].getName() + "Item Price: " + inCartItemsCpy[i].getPrice() + " X " + item_count[i]) ;
            }
        }
    }

    private boolean alreadyInCart(int[] added_items, int test_id){
        for(int id: added_items){
            if(test_id == id){
                System.out.println("Already in cart!");
                return true;
            }
        }

        return false;
    }

    // return incart items 
    public Item[] getInCartItems(){
        return this.incartItems;
    }

    // get in cart amount
    public int getInCartAmount(){
        return this.inCart;
    }
}
