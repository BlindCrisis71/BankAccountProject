package ezmoney.clap;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {


    protected Scanner consoleInput = new Scanner(System.in);


    /**
     * Show accounts tied to userId
     *
     * @param accountDatabase The list of all bank accounts
     * @param userID          The user id that may be tied to multiple bank accounts
     */
    public void listMyAccounts(ArrayList<Account> accountDatabase, int userID) {


        System.out.println("Your Account(s):\n");

        //Display the users accounts
        for (Account a : accountDatabase) {

            if (a.getUserID() == userID) {

                System.out.println(a.toString() + "\n");

            }
        }
    }


    /**
     * Delete the account specified
     *
     * @param accountDatabase The list of all bank accounts
     * @param userID          The user id that may be tied to multiple bank accounts
     */
    public void deleteAccount(ArrayList<Account> accountDatabase, int userID) {

        //Get the account number
        System.out.println("Enter the accounts number that you wish to delete: ");

        //TODO: Does this need try/catch block?
        int accountNumber = consoleInput.nextInt();


        //Flag if the account is found
        boolean found = false;


        //Delete the account if it is found
        for (Account a : accountDatabase) {

            if (a.getUserID() == userID && a.getAccountNumber() == accountNumber) {

                found = true;

                //Attempt to safely delete account
                if (a.getBalance() != 0) {

                    accountDatabase.remove(a);

                    System.out.println("The account was successfully deleted!");

                } else {

                    System.out.println("The account could not be deleted!");
                    System.out.println("It has an outstanding balance of: " + a.getBalance());
                }
            }

        }


        //Tell user the account was not found
        if (!found) {

            System.out.println("The specified account could not be found!");
        }

    }


    /**
     * Create a new account
     *
     * @param accountDatabase The list of all bank accounts
     */
    public void createAccount(ArrayList<Account> accountDatabase, String userId) {

        //TODO: use a try catch on input!!
        //Get the data for this account
        System.out.println("Enter a name for the new account: ");
        String name = consoleInput.nextLine();

        System.out.println("Enter a new pin for this account: ");
        int pin = consoleInput.nextInt();

        System.out.println("Enter the account type (Personal, Business, Checking, Saving): ");
        String type = consoleInput.nextLine();


        int userIDinput = 0;

        //Get user id if necessary (Admin)
        if(userId.equalsIgnoreCase("")){

            System.out.println("Enter an existing userID for this account (or 0 to generate a new id): ");
            userIDinput = consoleInput.nextInt();
        }else{

            //Set the userID if it is passed in
            userIDinput = Integer.parseInt(userId);
        }



        //Get the correct enum value
        Account.AccountType enumType = Account.convertString(type);


        //Attempt to create the account
        if (enumType == null) {
            System.out.println("The correct account type was not found.");
            System.out.println("The account could not be created!");

        } else {

            if(userIDinput == 0){

                //Generate the userID

                //Create the new account
                Account account = new Account(name, pin, enumType);
                accountDatabase.add(account);

                //Notify the user
                System.out.println("The account has been created!");
                System.out.println("Account info:");
                System.out.println(account.toString());

            }else{

                //Do not generate the userID

                //Create the new account
                Account account = new Account(name, pin, enumType, userIDinput);
                accountDatabase.add(account);

                //Notify the user
                System.out.println("The account has been created!");
                System.out.println("Account info:");
                System.out.println(account.toString());
            }
        }

    }


    /**
     * Deposit money to the account specified
     *
     * @param accountDatabase
     * @param userID
     */
    public void deposit(ArrayList<Account> accountDatabase, int userID) {

        //TODO: Use a try catch on input!!
        //Get the users input
        System.out.println("Enter your account number you wish to deposit to: ");
        int accountNumber = consoleInput.nextInt();

        System.out.println("Enter the amount you wish to deposit: ");
        double amount = consoleInput.nextDouble();


        //Flag if the account is found
        boolean found = false;


        //Find the correct account
        for (Account a : accountDatabase) {

            if (a.getUserID() == userID && a.getAccountNumber() == accountNumber) {

                found = true;

                a.deposit(amount);

                System.out.println("The money was successfully deposited!");
                System.out.println("Your new balance is: " + a.getBalance());
            }

        }


        //Tell user the account was not found
        if (!found) {

            System.out.println("The specified account could not be found!");
        }


    }


    /**
     * Withdraw money from the account specified
     *
     * @param accountDatabase
     * @param userID
     */
    public void withdraw(ArrayList<Account> accountDatabase, int userID) {


        //TODO: Use a try catch on input!!
        //Get the users input
        System.out.println("Enter your account number you wish to withdraw from: ");
        int accountNumber = consoleInput.nextInt();

        System.out.println("Enter the amount you wish to withdraw: ");
        double amount = consoleInput.nextDouble();


        //Flag if the account is found
        boolean found = false;


        //Find the correct account
        for (Account a : accountDatabase) {

            if (a.getUserID() == userID && a.getAccountNumber() == accountNumber) {

                found = true;

                //Attempt to withdraw money
                if (a.getBalance() - amount < 0) {

                    System.out.println("Cannot withdraw: " + amount + "!");
                    System.out.println("The balance is too low!: " + a.getBalance());

                } else {

                    a.withdraw(amount);

                    System.out.println("The money was successfully withdrawn!");
                    System.out.println("Your new balance is: " + a.getBalance());
                }

            }

        }


        //Tell user the account was not found
        if (!found) {

            System.out.println("The specified account could not be found!");
        }


    }


    /**
     * Get specified accounts activity
     *
     * @param accountDatabase
     * @param userID
     */
    public void requestAccountSummary(ArrayList<Account> accountDatabase, int userID) {


        //TODO: Use a try/catch block!
        //Get input
        System.out.println("Enter the accounts number that you want a summary for: ");
        int accountNumber = consoleInput.nextInt();


        //Flag if the account is found
        boolean found = false;


        //Find the account
        for (Account a : accountDatabase) {

            if (a.getUserID() == userID && a.getAccountNumber() == accountNumber) {

                //Display the account info
                found = true;
                System.out.println(a.toString());

            }
        }


        //Tell user the account was not found
        if (!found) {

            System.out.println("The specified account could not be found!");
        }


    }


    //Get specified accounts transaction history
    //TODO: This is the exact same code as in 'requestAccountSummary'. Should the two methods be merged?
    public void requestTransactionDetails(ArrayList<Account> accountDatabase, int userID) {


        //TODO: Use a try/catch block!
        //Get input
        System.out.println("Enter the accounts number that you want a summary for: ");
        int accountNumber = consoleInput.nextInt();


        //Flag if the account is found
        boolean found = false;


        //Find the account
        for (Account a : accountDatabase) {

            if (a.getUserID() == userID && a.getAccountNumber() == accountNumber) {

                //Display the account info
                found = true;
                System.out.println(a.toString());
                a.showActivity();

            }
        }

        //Tell user the account was not found
        if (!found) {

            System.out.println("The specified account could not be found!");
        }

    }


    /**
     * Send money from the specified account to another specified account
     *
     * @param accountDatabase
     * @param userID
     */
    public void transferMoney(ArrayList<Account> accountDatabase, int userID) {


        //TODO: Use a try/catch block!
        //Get input
        System.out.println("Enter the account you wish to transfer from: ");
        int srcNum = consoleInput.nextInt();

        System.out.println("Enter the account you wish to transfer to: ");
        int dstNum = consoleInput.nextInt();

        System.out.println("Enter the amount that you would like to transfer: ");
        double transAmount = consoleInput.nextDouble();


        //Hold the transfer accounts
        Account srcAccount = null;
        Account dstAccount = null;

        //Attempt to get the two accounts
        for (Account a : accountDatabase) {

            //Get source account
            if (a.getUserID() == userID && a.getAccountNumber() == srcNum) {

                srcAccount = a;

            }

            //Get destination account
            if (a.getAccountNumber() == dstNum) {

                dstAccount = a;
            }

        }


        //See if the srcAccount was found
        if (srcAccount == null) {

            System.out.println("Could not find the source account!");
            System.out.println("The transfer was canceled!");

            return;
        }

        //See if the dstAccount was found
        if (dstAccount == null) {

            System.out.println("Could not find the destination account!");
            System.out.println("The transfer was canceled!");

            return;
        }


        //See if enough money is in the src account
        if (srcAccount.getBalance() - transAmount < 0) {

            System.out.println("There is not enough money in the src account to transfer!");
            System.out.println("You requested: " + transAmount);
            System.out.println("You only have a balance of: " + srcAccount.getBalance());

            return;
        }


        //Transfer the money
        srcAccount.withdraw(transAmount);
        dstAccount.deposit(transAmount);

        System.out.println("The money was successfully transferred!");


    }


}
