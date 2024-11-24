package  SimplifiedShoppingCartSystem.modules.Cart;

import SimplifiedShoppingCartSystem.modules.Item

public class Cart extends Item
{
    private static float totalPrice;
    private static float totalPriceWithTax;
    static float TAX_RATE = 7;

    //specific attribute
    incartItems[i]
    private int cartId;
    private int incartItems;

    //default onstructor
    public Cart(){
        cartId++;
        incartItems = 0;
        totalPrice=0;
    }

    //method to remove an item from the cart
    private void removeFromCart(String itemToBeRemoved)
    {
        int i;
        for(int i=0; i<incartItems.lenght(); i++)
        {
            if(itemToBeRemoved==incartItems[i])
            {
                incart
            }
        }
    }
    // implementation for abstract method from the supper class
    @Override
    public double increaseInStockQuantity(){

    };

    @Override
    public double decreaseInStockQuantity(){

    };


    //method to calculate total price of items
       public float getTotalPrice() {
        return totalPrice;
    }





    //method for adding items
    int i=0;//item array index

    //adding individual item of  Item class
    public void addItem(Item individualItem)
    {
        incartItems[i]=individualItem;
        totalPrice += individualItem.price;
        i++;
    }

}