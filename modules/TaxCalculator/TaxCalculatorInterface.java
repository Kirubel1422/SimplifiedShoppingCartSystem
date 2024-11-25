package SimplifiedShoppingCartSystem.modules.TaxCalculator;

public interface TaxCalculatorInterface {
    public void calculatePrice();
    public void calculatePrice(boolean with_tax);
    public void setTaxRate(float tax_rate);
}