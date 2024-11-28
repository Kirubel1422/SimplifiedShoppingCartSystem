package modules.TaxCalculator;

import modules.Cart.Cart;
import modules.TaxCalculator.TaxCalculatorInterface.*;;

public class TaxCalculator extends Cart implements TaxCalculatorInterface{
    float total_price = 0f;
    float tax_rate = 5f;

    public void calculatePrice(){
        total_price = getTotalPrice();
        System.out.println("Total Price: (without tax) " + total_price);
    }

    public void calculatePrice(boolean with_tax){
        if(tax_rate == 5f){
            System.out.println("Using default tax rate: " + tax_rate);
        }

        total_price = getTotalPrice() + (tax_rate / 100) * getTotalPrice();
        System.out.println("Total Price: (" + tax_rate + "%) " + total_price);
    }

    public void setTaxRate(float tax_rate){
        this.tax_rate = tax_rate;
    }
}
