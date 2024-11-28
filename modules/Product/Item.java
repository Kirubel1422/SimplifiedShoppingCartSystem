package modules.Product;

public class Item {
    //Attributes
    private String name;
    private int id;
    private float price;
    private int inStock;

    private int in_cart_count = 0; // Count's how many of this object live in the cart
    private static int count = -2;


    //default constructor
    public Item()
    {//initializing attributes
        this.name="Unknown Product";
        this.price=0;
        this.inStock=1;
        Item.count ++;
        this.id = count;
    }

    //constructor with different arguements
    public Item(String name, float price){
        this.name=name;
        this.price=price;
        this.inStock = 0;
        Item.count ++;
        this.id = count;
    }

    //constructor with different arguements
    public Item(String name, float price, int inStock){
        this.name=name;
        this.price=price;
        this.inStock = inStock;
        Item.count ++;
        this.id = count;
    }
    
    // Display Item info
    public String displayInfo() {
        return "ID: " + this.id +
               " , Item name: " + this.name +
               " , Item price: " + this.price +
               " , InStock: " + this.inStock;
    }
    

    // Setters
    public void setName(String name)
    {
        this.name = name;
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
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public double getInStockQuantity(){
        return this.inStock;
    }

    public int getId(){
        return this.id;
    }

    public int getInCartCount(){
        return this.in_cart_count;
    }

    public void inc_in_cart_count () {
        this.in_cart_count ++;
    }

    // 
    public void inc(){
        this.inStock ++;
    }

    // 
    public void dec(){
        this.inStock --;
        System.out.println(this.inStock);
    }
}

