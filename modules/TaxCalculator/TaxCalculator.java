package modules.TaxCalculator;

import modules.Cart.Cart;

public class TaxCalculator extends Cart implements TaxCalculatorInterface{
    float total_price = 0f;
    float tax_rate = 5f;

    public void calculatePrice(){
        total_price = getTotalPrice();
        System.out.println("Total Price: (without tax) $ " + total_price);
    }

    public void calculatePrice(boolean with_tax){
        total_price = getTotalPrice() + (tax_rate / 100) * getTotalPrice();
        System.out.println("Total Price: (" + tax_rate + "%) $ " + total_price);
    }

    public void displayFinalPrice(){
        calculatePrice();
        calculatePrice(true);
    }

    public void setTaxRate(float rate){
        tax_rate = rate;
    }

    public float getTaxRate(){
        return this.tax_rate;
    }
}
