package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount{

    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;


    public ExtendedStrictBankAccount(int id, double balance) {
        super(id, balance);
    }

    private void makeTransaction(final int id, double amount) {
        if (checkUser(id)) {
            incrementTransactions();
            setBalance(getBalance() + amount);
        }
    }

    public void withdraw(final int id, final double amount) {
        if (isWithdrawAllowed(amount)) {
            makeTransaction(id, -amount);
        }
    }

    public void withdrawFromATM(final int id, final double amount) {
        withdraw(id, amount + ATM_TRANSACTION_FEE);
    }

    public void chargeManagementFees(final int id) {
        final double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * ExtendedStrictBankAccount.TRANSACTION_FEE;
        if (isWithdrawAllowed(feeAmount)) {
            withdraw(id, feeAmount);
            resetTransactions();
        }
    }
    
    private boolean isWithdrawAllowed(final double amount) {
        return getBalance() >= amount;
    }
}
