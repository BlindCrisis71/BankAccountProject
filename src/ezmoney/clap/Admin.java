package ezmoney.clap;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Customer {

    protected Scanner consoleInput = new Scanner(System.in);

    /**
     * Displays all accounts in the database
     * @param accountDatabase An arraylist of all accounts
     */
    public void listAllAccounts(ArrayList<Account> accountDatabase) {

        System.out.println("Complete list of accounts:\n");

        // Runs through every value in accountDatabase
        for (Account account : accountDatabase) {

            // Prints out account details
            System.out.println(account.toString() + "\n");
        }
    }

    /**
     * Displays all accounts belonging to a specific user id in the database
     * @param accountDatabase An arraylist of all accounts
     */
    public void listAccountsUserID(ArrayList<Account> accountDatabase) {

        int userID = 0;

        try {
            // Grabs the specific user id to search the database for
            System.out.println("Enter user id to view all accounts associated with it: ");
            userID = consoleInput.nextInt();
        } catch (Exception ex) {
            System.out.println("Incorrect input! Returning to main menu.");
        }

        for (Account account : accountDatabase) {

            // Checks database for an account that has the specified user id
            if (account.getUserID() == userID) {

                // Prints out account details
                System.out.println(account.toString() + "\n");
            }
        }
    }

    public void listAccountsUsername(ArrayList<Account> accountDatabase) {

        String username = "";

        try {
            // Grabs specific user name to search the database for
            System.out.println("Enter user name to view all accounts associated with it: ");
            username = consoleInput.nextLine();
        } catch (Exception ex) {
            System.out.println("Incorrect input! Returning to main menu.");
        }

        for (Account account : accountDatabase) {

            // Checks database for an account with the specified user name
            if (account.getHoldersName() == username) {

                // Prints out account details
                System.out.println(account);
            }
        }
    }

    /**
     * Deletes an account with help from the super class
     * @param accountDatabase
     */
    public void deleteAccount(ArrayList<Account> accountDatabase) {

        //Call the super method
        super.deleteAccount(accountDatabase, getUserID());

    }

    /**
     * Deposits money into account specified
     * @param accountDatabase
     */
    public void deposit(ArrayList<Account> accountDatabase){

        // Calls the super method
        super.deposit(accountDatabase, getUserID());

    }

    /**
     * Withdraws money into account specified
     * @param accountDatabase
     */
    public void withdraw(ArrayList<Account> accountDatabase){

        // Calls the super method
        super.withdraw(accountDatabase, getUserID());
    }

    /**
     * Get specified accounts activity
     * @param accountDatabase
     */
    public void requestAccountSummary(ArrayList<Account> accountDatabase) {

        // Calls the super method
        super.requestAccountSummary(accountDatabase, getUserID());
    }

    /**
     * Get specified accounts transaction history
     * @param accountDatabase
     */
    public void requestTransactionDetails(ArrayList<Account> accountDatabase) {

        // Calls the super method
        super.requestTransactionDetails(accountDatabase, getUserID());
    }

    /**
     * Send money from the specified account to another specified account
     * @param accountDatabase
     */
    public void transferMoney(ArrayList<Account> accountDatabase) {

        // Calls the super method
        super.transferMoney(accountDatabase, getUserID());
    }


    /**
     * Returns the userID by requesting for user input
     * @return
     */
    public int getUserID(){

        try {
            //Get input from the user
            System.out.println("Enter the userID for the account you want: ");

            return consoleInput.nextInt();
        } catch (Exception ex) {

            System.out.println("Incorrect input!");
        }

        return 0;
    }

}
