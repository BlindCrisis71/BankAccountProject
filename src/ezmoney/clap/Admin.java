package ezmoney.clap;

import java.util.ArrayList;

public class Admin extends Customer {


    //TODO: Use this example below brandyn. Some methods in customer require a userID so use the 'getuserID' method.

    /**
     * Deletes an account with help from the super class
     * @param accountDatabase
     */
    public void deleteAccount(ArrayList<Account> accountDatabase) {

        //Call the super method
        super.deleteAccount(accountDatabase, getUserID());
    }


    /**
     * Returns the userID by requesting for user input
     * @return
     */
    public int getUserID(){

        //TODO: Use try/catch block for input!
        //Get input from the user
        System.out.println("Enter the userID for the account you want to delete: ");

        return consoleInput.nextInt();
    }

}
