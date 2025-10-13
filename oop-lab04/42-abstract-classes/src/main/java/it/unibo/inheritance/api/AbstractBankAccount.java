package it.unibo.inheritance.api;

public abstract class AbstractBankAccount implements BankAccount{
    
    protected static final double ATM_TRANSACTION_FEE = 1;
    protected static final double MANAGEMENT_FEE = 5;

    private final AccountHolder holder;
    private double balance;
    private int transactions;
    
    public AbstractBankAccount(final AccountHolder accountHolder, final double balance) {
        this.holder = accountHolder;
        this.balance = balance;
        this.transactions = 0;
    }

    public abstract void chargeManagementFees(int id);

    public void deposit(int id, double amount) { 
        makeTransaction(id, amount); 
    }

    public void depositFromATM(int id, double amount) {
        makeTransaction(id, amount - ATM_TRANSACTION_FEE);
    }

    
    public void withdraw(int id, double amount) {
        if(isWithDrawAllowed(amount)) {
            makeTransaction(id, -amount);
        }
    }

    public void withdrawFromATM(int id, double amount) {
        withdraw(id, amount + ATM_TRANSACTION_FEE);
    }

    public AccountHolder getAccountHolder() {
        return this.holder;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    protected void makeTransaction(int id, double amount) {
        if(checkUser(id)) {
            this.balance += amount;
            incrementTransactions();
        }
    }

    protected void resetTransactions() {
        this.transactions = 0;
    }

    protected void incrementTransactions() {
        this.transactions++;
    }

    private boolean checkUser(int id) {
        return holder.getUserID() == id;
    }

    protected abstract boolean isWithDrawAllowed(double amount);
}
