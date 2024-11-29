package utils;

import java.util.Scanner;
import modules.TaxCalculator.TaxCalculator;

public class TaxHelper {
    // Method to set the tax rate for the given TaxCalculator object
    public static void setTax(TaxCalculator taxCalculator){
        // Declaring a variable for tax rate
        float taxRate = 0f;

        // Creating a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Asking the user to enter a tax rate
        System.out.print("Please Enter Tax Rate: ");
        taxRate = sc.nextFloat();

        // Validating the tax rate entered by the user
        if(taxRate < 0){
            // Displaying an error message if the tax rate is invalid
            System.out.println("Invalid tax rate!!");
        }

        // Setting the valid tax rate to the taxCalculator object
        taxCalculator.setTaxRate(taxRate);

        // Informing the user that the tax rate has been successfully set
        System.out.println("Tax rate for your cart has been successfully set!");
    }
}
