package ezmoney.clap;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

//This is the driver class
public class Bank {

    public static void main(String[] args) {

        //TODO: Serialize?
        //Hold all the accounts in the bank
        ArrayList<Account> accountDatabase = new ArrayList<>();



        //Hold user data
        boolean login = false;
        String userId = "";
        String pin = "";
        String selection = "";

        String userType = "";
        int defaultAdminPassword = 1234;


        //Get input
        Scanner consoleInput = new Scanner(System.in);


        //TODO: Update this test code?
        Customer customer = new Customer();
        Admin admin = new Admin();






        /*
        Get the account type
         */
        while(true){

            //TODO: use a try catch on input

            //Get account type
            System.out.println("Enter user type (Admin or Customer): ");
            System.out.println("(Enter 'exit' to close the program)");
            userType = consoleInput.nextLine();



            //End the program if necessary
            endProgram(userType);


            //Check type
            if(!userType.equalsIgnoreCase("admin") && !userType.equalsIgnoreCase("customer")){

                //Neither account type selected
                System.out.println("Incorrect value entered!");

            }else{

                //Account selected
                //Move onto next code
                break;
            }

        }






        /*
        Run code for bank teller
        */
        if(userType.equalsIgnoreCase("admin")){



            //Login admin
            while(!login){


                //TODO: use a try catch on input
                //Get the pin
                System.out.println("\nEnter the Admin pin: ");
                System.out.println("Enter 'exit' to close the program.");

                pin = consoleInput.nextLine();


                //Exit the program if necessary
                endProgram(pin);


                //TODO: See if try catch is necessary
                //The password matches
                if(Integer.parseInt(pin) == defaultAdminPassword){

                    //Break this loop
                    System.out.println("\nLogging in... Welcome!\n");
                    login = true;
                    break;

                }else{

                    System.out.println("Invalid credentials!");
                }
            }




            //Show admin selection
            while(login){


                //TODO: use a try catch on input
                //Show selection
                System.out.println("Enter a selection:");
                System.out.println("1. List all accounts");
                System.out.println("2. List Accounts with options");
                System.out.println("3. Delete Account");
                System.out.println("4. Create Account");
                System.out.println("5. Deposit Money into an account");
                System.out.println("6. Withdraw money from an account");
                System.out.println("7. Request an account summary");
                System.out.println("8. Request account transaction details");
                System.out.println("9. Transfer money between accounts");

                System.out.println("Selection: ");

                //Get input
                selection = consoleInput.nextLine();



                //Exit the program if necessary
                endProgram(selection);



                //Run Admin code
                switch(Integer.parseInt(selection)){

                    case 1:

                        //List all accounts in the bank
                        admin.listAllAccounts(accountDatabase);

                        break;
                    case 2:

                        //This lists certain accounts based on user inputs
                        admin.listAccounts(accountDatabase);

                        break;
                    case 3:

                        //Delete the specified account
                        admin.deleteAccount(accountDatabase);

                        break;
                    case 4:

                        //Create a new account
                        admin.createAccount(accountDatabase, "");

                        break;
                    case 5:

                        //Deposit money into the specified account
                        //TODO: Do NOT pass userID from here. Override the customer methods in customer if needed.
                        admin.deposit(accountDatabase);

                        break;
                    case 6:

                        //Withdraw money from the specified account
                        //TODO: Do NOT pass userID from here. Override the customer methods in customer if needed.
                        admin.withdraw(accountDatabase);

                        break;
                    case 7:

                        //Get info from specified account
                        //TODO: Do NOT pass userID from here. Override the customer methods in customer if needed.
                        admin.requestAccountSummary(accountDatabase);

                        break;
                    case 8:

                        //Get transaction history from specified account
                        //TODO: Do NOT pass userID from here. Override the customer methods in customer if needed.
                        admin.requestTransactionDetails(accountDatabase);

                        break;
                    case 9:

                        //Send money from a specified account to another specified account
                        //TODO: Do NOT pass userID from here. Override the customer methods in customer if needed.
                        admin.transferMoney(accountDatabase);

                        break;

                    default:
                        System.out.println("The entered selection was not in the list!");
                }



            }



        }









        /*
        Loop through customer login attempts
         */
        if(userType.equalsIgnoreCase("customer")) {


            //Loop through customer login attempts
            while(!login){


                //TODO: use a try catch on input
                //Get credentials
                System.out.println("\n-----LOGIN-----");

                System.out.println("Enter UserID:");

                //Hold input
                userId = consoleInput.nextLine();


                //End program if necessary
                endProgram(userId);


                System.out.println("Enter Pin:");

                //Hold input
                pin = consoleInput.nextLine();

                //End program if necessary
                endProgram(pin);



                //See if account exists
                //Loop through all accounts
                for(Account a : accountDatabase){

                    //See if name matches
                    if(a.getUserID() == Integer.parseInt(userId)){

                        //Found an account with the same name!

                        //See if pin matches
                        if(a.getPin() == Integer.parseInt(pin)){

                            //Notify account has been found
                            login = true;
                            System.out.println("\nLogging in... Welcome!\n");
                            break;
                        }

                    }
                }



                //Break loop if the account was found
                if(login) {

                    //Tell user about login attempt
                    System.out.println("The account was found!");
                    break;

                }else{

                    //Tell user about login attempt
                    System.out.println("The account was not found!");
                }


            }






            //Loop through selection options
            while(login){


                //TODO: use a try catch on input

                //Show selection
                System.out.println("Enter a selection:");
                System.out.println("1. List my Accounts");
                System.out.println("2. Delete my Account");
                System.out.println("3. Create a new Account");
                System.out.println("4. Deposit Money into my account");
                System.out.println("5. Withdraw money from my account");
                System.out.println("6. Request an account summary");
                System.out.println("7. Request my account transaction details");
                System.out.println("8. Transfer money to another account");

                System.out.println("Selection: ");

                //Get input
                selection = consoleInput.nextLine();



                //Exit the program if necessary
                endProgram(selection);



                //Run customer code
                switch(Integer.parseInt(selection)){


                    //TODO: Make sure if Integer.parseInt needs try/catch block

                    case 1:

                        //Show accounts tied to userId
                        customer.listMyAccounts(accountDatabase, Integer.parseInt(userId));

                        break;
                    case 2:

                        //Delete account specified
                        customer.deleteAccount(accountDatabase, Integer.parseInt(userId));

                        break;
                    case 3:

                        //Create a new account
                        customer.createAccount(accountDatabase, userId);

                        break;
                    case 4:

                        //Deposit money to the account specified
                        customer.deposit(accountDatabase, Integer.parseInt(userId));

                        break;
                    case 5:

                        //Withdraw money from the account specified
                        customer.withdraw(accountDatabase, Integer.parseInt(userId));

                        break;
                    case 6:

                        //Get specified accounts activity
                        customer.requestAccountSummary(accountDatabase, Integer.parseInt(userId));

                        break;
                    case 7:

                        //Get specified accounts transaction history
                        customer.requestTransactionDetails(accountDatabase, Integer.parseInt(userId));

                        break;
                    case 8:

                        //Send money from the specified account to another specified account
                        customer.transferMoney(accountDatabase, Integer.parseInt(userId));

                        break;

                    default:
                        System.out.println("The entered selection was not in the list!");

                }
            }


        }





    }


    public static void endProgram(String value){

        if(value.equalsIgnoreCase("exit")){
            System.out.println("\nThank you for your business!");
            System.out.println("Please come again!");
            exit(0);
        }

    }

}
