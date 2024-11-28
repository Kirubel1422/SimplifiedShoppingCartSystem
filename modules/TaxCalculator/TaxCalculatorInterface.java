package modules.TaxCalculator;

public interface TaxCalculatorInterface {
    public void calculatePrice();
    public void calculatePrice(boolean with_tax);
    public void displayFinalPrice();
}