package ezmoney.clap;

import java.util.Date;

public class AccountActivity {

    private Date dateAccessed;

    private double amountMoved;

    private int transferredAccountNumber;

    private MoveType moveType;

    enum MoveType {

        WITHDRAW("Withdraw"),
        DEPOSIT("Deposit"),
        TRANSFER("Transfer");

        private String type;

        MoveType(String type) {

            this.type = type;
        }

        @Override
        public String toString() {

            return type;
        }
    }

    public AccountActivity(Date dateAccessed, double amountMoved, int transferredAccountNumber, MoveType moveType) {

        this.dateAccessed = dateAccessed;
        this.amountMoved = amountMoved;
        this.transferredAccountNumber = transferredAccountNumber;
        this.moveType = moveType;
    }

    @Override
    public String toString() {

        return "Date accessed: " + dateAccessed +
               "Type of transaction: " + moveType.toString() +
               "\nAmount moved: " + amountMoved +
               "\nAccount number: " + transferredAccountNumber;
    }
}
