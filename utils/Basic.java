package SimplifiedShoppingCartSystem.utils;

public class Basic {
    // Method to validate user input
    public static boolean validateInput(int[] validOptions, int choice){
        // Check if the selected choice is part of the valid array of 
        // options
        for(int validOption: validOptions){
            if(validOption == choice){
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
}
