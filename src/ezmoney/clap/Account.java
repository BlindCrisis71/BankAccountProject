package ezmoney.clap;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {


    //TODO: Use static counter to keep track of ids
    //Unique id's are created by incrementing
    //Old id's are never recycled
    public static int accountNumberCounter = 9000;
    public static int userIdCounter = 100;



    /**
     * Amount of money in this account
     */
    private double money;

    /**
     * Name of account owner
     */
    private String name;

    /**
     * Pin to access account
     */
    private int pin;

    /**
     * User ID to access account
     */
    private int userID;

    /**
     * Unique account id
     */
    private int accountNumber;

    /**
     * Activity log for this account
     */
    private ArrayList<AccountActivity> activitylist;

    /**
     * Object to access AccountType
     */
    private AccountType accountType;

    /**
     * Enum to keep track of what type of account this is
     */
    enum AccountType {

        // Types of accounts
        PERSONAL("Personal"),
        BUSINESS("Business"),
        CHECKING("Checking"),
        SAVING("Saving");

        // Holds the type of account
        private String type;

        // Constructor
        AccountType(String type) {

            this.type = type;
        }

        /**
         * Displays type of account
         * @return Type of account
         */
        @Override
        public String toString() {

            return type;
        }


    }

    /**
     * Constructor
     * @param accountType This account's type
     */
    public Account(String name, int pin, AccountType accountType, int userID) {

        this.name = name;
        this.pin = pin;
        this.accountType = accountType;
        this.userID = userID;

        //TODO: Generate the new AccountNumber

    }

    /**
     * Constructor
     * @param accountType This account's type
     */
    public Account(String name, int pin, AccountType accountType) {

        this.name = name;
        this.pin = pin;
        this.accountType = accountType;

        //TODO: Generate the new AccountNumber
        //TODO: Generate user id

    }

    public double getBalance(){
        return money;
    }

    /**
     * Deposits money into account
     * @param moneyAmount Amount of money to be deposited
     */
    public void deposit(double moneyAmount) {

        // TODO Write "deposit" function
    }

    /**
     * Withdraws money from account
     * @param moneyAmount Amount of money to be withdrawn
     */
    public void withdraw(double moneyAmount) {

        // TODO Write "withdraw" function
    }

    /**
     * Returns the type of this account
     * @return This account's type
     */
    public AccountType getType() {

        return accountType;
    }

    /**
     * Returns the user's id
     * @return User id
     */
    public int getUserID() {

        return userID;
    }

    /**
     * Returns the user's pin
     * @return User's pin
     */
    public int getPin() {

        return pin;
    }

    /**
     * Returns the account holder's name
     * @return Account holder's name
     */
    public String getHoldersName() {

        return name;
    }

    /**
     * Returns the account number
     * @return Account number
     */
    public int getAccountNumber() {

        return accountNumber;
    }

    /**
     * Displays the activity log for this account
     */
    public void showActivity() {

        // TODO Double check I wrote "showActivity" correctly after finishing the "AccountActivity" class
        for (AccountActivity activity : activitylist) {

            System.out.println(activity.toString());
        }
    }

    /**
     * Converts an input string from the console into the correct enum type
     * @param rawType
     * @return
     */
    public static AccountType convertString(String rawType){

        if(Account.AccountType.PERSONAL.toString().equalsIgnoreCase(rawType)){
            return Account.AccountType.PERSONAL;
        }

        if(Account.AccountType.BUSINESS.toString().equalsIgnoreCase(rawType)){
            return Account.AccountType.BUSINESS;
        }

        if(Account.AccountType.CHECKING.toString().equalsIgnoreCase(rawType)){
            return Account.AccountType.CHECKING;
        }

        if(Account.AccountType.SAVING.toString().equalsIgnoreCase(rawType)){
            return Account.AccountType.SAVING;
        }

        return null;
    }

    /**
     * Returns a summary of this account
     * @return Summary of this account
     */
    @Override
    public String toString() {

        //TODO: Format money to use money symbol!
        return "Account number: " + accountNumber +
                "\nUser ID: " + userID +
                "\nName: " + name +
                "\nAccount type: " + accountType +
                "\nMoney: " + money + "\n" +
                "\nPin: " + pin + "\n";
    }

}
