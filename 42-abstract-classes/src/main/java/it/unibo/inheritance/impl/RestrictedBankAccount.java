package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AbstractBankAccount;
import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

    public RestrictedBankAccount(AccountHolder accountHolder, double balance) {
        super(accountHolder, balance);
    }

    protected boolean isWithDrawAllowed(double amount) {
        return getBalance() > amount;
    }

    public void chargeManagementFees(int id) {
        double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
        if(isWithDrawAllowed(id)){
            makeTransaction(id, -feeAmount);
            resetTransactions();
        }
    }
    
}
