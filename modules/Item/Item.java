package  SimplifiedShoppingCartSystem.modules.Item;

abstract public class Item {
    //Attributes
    private String itemName;
    static int ID;
    private float itemPrice;
    private boolean itemVisibility;
    private int inStock;


    //default constructor
    public Item()
    {//initializing attributes
        itemName="unknown Product";
        ID++;
        itemPrice=0;
        itemVisibility= false;
        inStock=1;
    }

    //constructor with different arguements
    public Item(String newName, float newPrice,boolean itemNewVisibility){
        this.itemName=newName;
        this.itemPrice=newPrice;
        this.itemVisibility=itemNewVisibility;
        ID++;
    }

    // necessary accessor and mutator methods
    //using setter method for name of an Item
    public void setItemName(String newName)
    {
        this.itemName=newName;
    }
    //using setter method visibility
    public void setVisibility(boolean newItemVisibility)
    {
        this.itemVisibility=newItemVisibility;
    }

    //using setter method for item price
    public void setItemPrice(float price )
    {
        this.itemPrice=price;
    }

    //getter methods

    //using setter method for name of an Item
    public String getItemName()
    {
        return itemName;
    }
    //using setter method visibility
    public boolean setVisibility()
    {
        return itemVisibility;
    }

    //using setter method for item price
    public double getitemPrice()
    {
        return itemPrice;
    }

    public double getInStockQuantity(){
        return inStock;
    }


    //abstracts method to be implemented in the subclass
    abstract public double increateInStockQuantity();
    abstract public double decreaseInStockQuantity();

}



