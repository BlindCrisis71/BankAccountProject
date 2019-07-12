package ezmoney.clap;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTest {

    ArrayList<Account> testAccounts = new ArrayList<>();
    Customer cust = new Customer();

    //TODO: There is a problem, junit does not allow console input...
    //TODO: Inorder to fix this, console input data must be passed to methods externally

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void listMyAccounts() {
    }

    @Test
    public void deleteAccount() {
    }

    @Test
    public void createAccount() {




    }

    @Test
    public void deposit() {
    }

    @Test
    public void withdraw() {
    }

    @Test
    public void requestAccountSummary() {
    }

    @Test
    public void requestTransactionDetails() {
    }

    @Test
    public void transferMoney() {
    }
}