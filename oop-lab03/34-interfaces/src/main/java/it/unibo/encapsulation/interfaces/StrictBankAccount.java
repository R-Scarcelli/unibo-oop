package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {
    
    private static double ATM_TRANSACTION_FEE = 1;

    private final int id;
    private double balace;
    private int transactions;

    public StrictBankAccount(final int id, double balace){
        this.id = id;
        this.balace = balace;
        this.transactions = 0;
    }

    private void makeTransaction(final int id, final double amount) {
        if(this.id == id) {
            this.transactions++;
            this.balace += amount;
        }
    }

    public void withdraw(int id, double amount) {
        if(amount <= balace){
            makeTransaction(id, -amount);
        }
    }

    public void deposit(int id, double amount) {
        makeTransaction(id, amount);
    }

    public void depositFromATM(int id, double amount) {
        makeTransaction(id, amount-ATM_TRANSACTION_FEE);
    }

    public void withdrawFromATM(int id, double amount) {
        if(amount <= balace){
            makeTransaction(id, -amount-ATM_TRANSACTION_FEE);
        }
    }
        
    public void chargeManagementFees(int id) {
        double fees = 5+transactions*0.1;
        if( fees <= balace){
            makeTransaction(id, -fees);
        }
    }

    public double getBalance() {
       return this.balace;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }
    
}
