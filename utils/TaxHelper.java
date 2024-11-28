package utils;

import java.util.Scanner;

import modules.TaxCalculator.TaxCalculator;

public class TaxHelper  {
    public static void setTax(TaxCalculator taxCalculator){
        float taxRate = 0f;

        Scanner sc = new Scanner(System.in);

        System.out.print("Please Enter Tax Rate: ");
        taxRate = sc.nextFloat();

        if(taxRate < 0){
            System.out.println("Invalid tax rate!!");
        }

        taxCalculator.setTaxRate(taxRate); 

        System.out.println("Tax rate for your cart has been successfully set!");
    }
}
