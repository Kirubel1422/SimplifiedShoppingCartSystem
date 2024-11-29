package modules.TaxCalculator;

import modules.Cart.Cart;

/**
 * The TaxCalculator class handles price calculations with or without tax.
 * It extends the Cart class to access cart-related methods and implements
 * the TaxCalculatorInterface for additional tax-related functionality.
 */
public class TaxCalculator extends Cart implements TaxCalculatorInterface {

    // Stores the total price of items in the cart
    float total_price = 0f;

    // Default tax rate for calculations
    float tax_rate = 5f;

    /**
     * Calculates and displays the total price of items in the cart without tax.
     */
    public void calculatePrice() {
        total_price = getTotalPrice();  // Fetch the total price from the Cart class
        System.out.println("Total Price: (without tax) $ " + total_price);
    }

    /**
     * Overloaded method: Calculates and displays the total price of items
     * in the cart with or without tax based on the parameter.
     *
     * @param with_tax - If true, tax is included in the total price.
     */
    public void calculatePrice(boolean with_tax) {
        total_price = getTotalPrice() + (tax_rate / 100) * getTotalPrice();  // Calculate total with tax
        System.out.println("Total Price: (" + tax_rate + "%) $ " + total_price);
    }

    /**
     * Displays the final price of items in the cart by calling both the 
     * calculatePrice methods (with and without tax).
     */
    public void displayFinalPrice() {
        calculatePrice();       // Displays the price without tax
        calculatePrice(true);   // Displays the price with tax
    }

    /**
     * Sets a new tax rate for price calculations.
     *
     * @param rate - New tax rate to be applied.
     */
    public void setTaxRate(float rate) {
        tax_rate = rate;
    }

    /**
     * Returns the current tax rate.
     *
     * @return The tax rate as a float.
     */
    public float getTaxRate() {
        return this.tax_rate;
    }
}
