package utils;

import modules.Product.Item;

public class Basic {
    // Method to validate user input for String sets
    public static boolean validateInput(String[] validOptions, String choice){
        // Check if the selected choice is part of the valid array of 
        // options
        for(String validOption: validOptions){
            if(validOption.equals(choice)){
                return true;
            }
        }

        return false;
    }

     // Method to validate user input for String sets with case-sensitivity flag
     public static boolean validateInput(String[] validOptions, String choice, boolean i){
        // Check if the selected choice is part of the valid array of 
        // options
        for(String validOption: validOptions){
            if(validOption.toLowerCase().equals(choice.toLowerCase())){
                return true;
            }
        }

        return false;
    }

    // Method to display a friendly error
    public static void displayError(String error){
        System.out.println(error);
    }

     // Method to display a friendly error
     public static void displayError(){
        System.out.println("Something went wrong!");
    }

    // Method to print all arrays
    public static void printArray(Item[] array){
        for(Item item : array){
            if(item != null){
                System.out.println(item.displayInfo());
            }
        }
    }

    // Check items existence: used in addItemToCart
    public static boolean itemExists(Item[] items){
        for(Item item: items){
            if(item != null){
                return true;
            }
        }

        return false;
    }
}
