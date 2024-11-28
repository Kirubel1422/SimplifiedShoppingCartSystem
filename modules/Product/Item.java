package modules.Product;

public class Item {
    //Attributes
    private String name;
    private int id;
    private float price;
    private boolean isVisible;
    private int inStock;
    private static int count = -1;


    //default constructor
    public Item()
    {//initializing attributes
        this.name="Unknown Product";
        this.price=0;
        this.isVisible= false;
        this.inStock=1;
        Item.count ++;
        this.id = count;
    }

    //constructor with different arguements
    public Item(String name, float price, boolean isVisible){
        this.name=name;
        this.price=price;
        this.isVisible=isVisible;
        this.inStock = 0;
        Item.count ++;
        this.id = count;
    }

    //constructor with different arguements
    public Item(String name, float price, boolean isVisible, int inStock){
        this.name=name;
        this.price=price;
        this.isVisible=isVisible;
        this.inStock = inStock;
        Item.count ++;
        this.id = count;
    }
    
    // Display Item info
    public String displayInfo() {
        return "ID: " + this.id +
               " , Item name: " + this.name +
               " , Item price: " + this.price +
               " , Status: " + (this.isVisible ? "Yes" : "No") +
               " , InStock: " + this.inStock;
    }
    

    // Setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setVisibility(boolean isVisible)
    {
        this.isVisible = isVisible;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public void setInStock(int inStock){
        this.inStock = inStock;
    }

    // Getters
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public double getInStockQuantity(){
        return inStock;
    }

    public boolean getVisibility(){
        return this.isVisible;
    }

    public int getId(){
        return this.id;
    }

    // 
    public void inc(){
        this.inStock ++;
    }

    // 
    public void dec(){
        this.inStock --;
    }
}

