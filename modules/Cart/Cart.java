package  SimplifiedShoppingCartSystem.modules.Cart;

import SimplifiedShoppingCartSystem.modules.Product.*;


public class Cart extends Item
{
    private static float totalPrice;
    static float TAX_RATE = 7;

    //specific attribute
    private Item[] incartItems = new Item[5];
    private int cartId = 0;
    private int incartItemsnumber;

    //default constructor
    public Cart(){
        cartId++;
        incartItemsnumber = 0;
        totalPrice=0;
    }

    //method to remove an item from the cart
    private void removeFromCart(Item itemToBeRemoved)
    {
        if(incartItemsnumber>=1) {
            
            Item[] incartArrayCopy = new Item[incartItems.length - 1];

            for (int i = 0; i < incartItems.length; i++) {
                if (itemToBeRemoved != incartItems[i]) {
                    incartArrayCopy[j] = incartItems[j];
                }
            }

            incartItems = incartArrayCopy;

            //whenever the item is removed from the cart, the number of item in stock increases
            inc();
            incartItemsnumber--;
        }
        else {
            System.out.println("There is no item in the cart to remove.");
        }
        }


    //method to calculate total price of items
    public float getTotalPrice() {
        return totalPrice;
    }


    //method for adding items
    int i=0;//item array index

    //adding individual item of  Item class
    public void addIteminCart(Item individualItem){
        if(individualItem != null && individualItem.getInStockQuantity() > 0) {
            incartItems[i] = individualItem;
            totalPrice += individualItem.getPrice();
            dec();
            incartItemsnumber++;
            i++;
        }
        else{
            System.out.println("There is no item in the stock");
        }
    }

    // get in cart items
    public Item[] getInCartItems(){
        return this.incartItems;
    }
}