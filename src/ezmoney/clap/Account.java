package ezmoney.clap;

import java.util.ArrayList;

public class Account {

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
    public Account(AccountType accountType) {

        this.accountType = accountType;

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
     * Returns a summary of this account
     * @return Summary of this account
     */
    @Override
    public String toString() {

        return "Account number: " + accountNumber +
                "\nUser ID: " + userID +
                "\nName: " + name +
                "\nAccount type: " + accountType +
                "\nMoney: " + money + "\n";
    }
}