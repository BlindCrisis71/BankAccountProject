package ezmoney.clap;

import java.util.Date;

public class AccountActivity {

    /**
     * Date when this account was last accessed
     */
    private Date dateAccessed;

    /**
     * Amount of money being transferred
     */
    private double amountMoved;

    /**
     * Account number for transaction
     */
    private int transferredAccountNumber;

    /**
     * Type of account activity
     */
    private MoveType moveType;

    enum MoveType {

        // Account types
        WITHDRAW("Withdraw"),
        DEPOSIT("Deposit"),
        TRANSFER("Transfer");

        private String type;

        /**
         * Constructor
         * @param type
         */
        MoveType(String type) {

            this.type = type;
        }

        /**
         * Displays the type of transaction
         * @return Type of transaction
         */
        @Override
        public String toString() {

            return type;
        }
    }

    /**
     * Constructor
     * @param amountMoved How much money was transferred
     * @param transferredAccountNumber Account number for transfer
     * @param moveType Type of transaction
     */
    public AccountActivity(double amountMoved, int transferredAccountNumber, MoveType moveType) {

        dateAccessed = new Date();
        this.amountMoved = amountMoved;
        this.transferredAccountNumber = transferredAccountNumber;
        this.moveType = moveType;
    }

    /**
     * Displays activity transcript
     * @return Activity transcript
     */
    @Override
    public String toString() {

        return "Date accessed: " + dateAccessed.toString() +
               "Type of transaction: " + moveType.toString() +
               "\nAmount moved: " + amountMoved +
               "\nAccount number: " + transferredAccountNumber;
    }
}
