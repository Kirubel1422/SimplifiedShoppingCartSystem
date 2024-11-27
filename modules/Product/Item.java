package SimplifiedShoppingCartSystem.modules.Product;

public class Item {
    //Attributes
    private String name;
    static int id = 0;
    private float price;
    private boolean isVisible;
    private int inStock;


    //default constructor
    public Item()
    {//initializing attributes
        name="Unknown Product";
        id++;
        price=0;
        isVisible= false;
        inStock=1;
    }

    //constructor with different arguements
    public Item(String name, float price, boolean isVisible){
        this.name=name;
        this.price=price;
        this.isVisible=isVisible;
        this.inStock = 0;
        id++;
    }

    //constructor with different arguements
    public Item(String name, float price, boolean isVisible, int inStock){
        this.name=name;
        this.price=price;
        this.isVisible=isVisible;
        this.inStock = inStock;
        id++;
    }
    
    // Display Item info
    public String displayInfo() {
        return "ID: " + Item.id +
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
        return Item.id;
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

