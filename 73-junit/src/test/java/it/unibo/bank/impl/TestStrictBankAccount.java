package it.unibo.bank.impl;

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class for the {@link StrictBankAccount} class.
 */
class TestStrictBankAccount {
     private static final int AMOUNT = 100;

    // Create a new AccountHolder and a StrictBankAccount for it each time tests are executed.
    private AccountHolder mRossi;
    private BankAccount bankAccount;

    /**
     * Prepare the tests.
     */
    @BeforeEach
    public void setUp() {
        mRossi = new AccountHolder("Mario", "Rossi", 0);
        bankAccount = new StrictBankAccount(mRossi, 0.0);
    }

    /**
     * Test the initial state of the StrictBankAccount.
     */
    @Test
    public void testInitialization() {
        assertEquals(0, mRossi.getUserID());
        assertEquals(mRossi, bankAccount.getAccountHolder());
        assertEquals(0.0, bankAccount.getBalance());
    }

    /**
     * Perform a deposit of 100€, compute the management fees, and check that the balance is correctly reduced.
     */
    @Test
    public void testManagementFees() {
        bankAccount.deposit(mRossi.getUserID(), AMOUNT);
        assertEquals(1, bankAccount.getTransactionsCount());
        assertEquals(AMOUNT, bankAccount.getBalance());
        
        final double feeAmount = 
            StrictBankAccount.MANAGEMENT_FEE + 
            this.bankAccount.getTransactionsCount() * StrictBankAccount.TRANSACTION_FEE;
       
        bankAccount.chargeManagementFees(mRossi.getUserID());
        assertEquals(0, bankAccount.getTransactionsCount());
        assertEquals(AMOUNT - feeAmount, bankAccount.getBalance());
    }

    /**
     * Test that withdrawing a negative amount causes a failure.
     */
    @Test
    public void testNegativeWithdraw() {
        assertThrows(IllegalAccessException.class, () -> {
            this.bankAccount.withdraw(mRossi.getUserID(), -AMOUNT);
        });
    }

    /**
     * Test that withdrawing more money than it is in the account is not allowed.
     */
    @Test
    public void testWithdrawingTooMuch() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.bankAccount.withdraw(mRossi.getUserID(), AMOUNT*AMOUNT);
        });
    }
}
