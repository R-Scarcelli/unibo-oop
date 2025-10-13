package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AbstractBankAccount;
import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount{

    public ClassicBankAccount(AccountHolder accountHolder, double balance) {
        super(accountHolder, balance);
    }

    protected boolean isWithDrawAllowed(double amount) {
        return true;
    }

    @Override
    public void chargeManagementFees(int id) {
        if(isWithDrawAllowed(id)) {
            makeTransaction(id, -MANAGEMENT_FEE);
            resetTransactions();
        }
    }
    
}
