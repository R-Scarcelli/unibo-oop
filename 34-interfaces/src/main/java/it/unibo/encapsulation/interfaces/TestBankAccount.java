package it.unibo.encapsulation.interfaces;

public class TestBankAccount {

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        // 1-3
        AccountHolder andreaR = new AccountHolder("Andrea", "Rossi", 1);
        System.out.println(andreaR.toString());

        AccountHolder alexB = new AccountHolder("Alex", "Bianchi", 2);
        System.out.println(alexB.toString());

        BankAccount rossiCount = new SimpleBankAccount(1, 0);
        BankAccount bianchiCount = new StrictBankAccount(2, 0);

        /* 4: il compilatore si aspetta in nelle variabili Rossicount e Bianchicount due variabili di 
            tipo BankAccount (SimpleBankAccount e StrictBankAccount) lo sono poichè ne implementano l'interfaccia
        */ 

        //5-7
        rossiCount.deposit(1, 10000);
        rossiCount.withdraw(1, 15000);
        System.out.println("[Rossi: " + rossiCount.getBalance() + "]\n");
        bianchiCount.deposit(2, 10000);
        bianchiCount.withdraw(2, 15000);
        System.out.println("[Bianchi: " + bianchiCount.getBalance() + "]\n");

        //8 Mi aspetto che il conto di Rossi vada in rosso poichè è un SimpleBankAccount
        // mentre quello di Bianchi avrà la stessa cifra poichè l'operazione non va a buon fine

        //9-11
        rossiCount.deposit(1, 10000);
        rossiCount.chargeManagementFees(1);
        System.out.println("[Rossi: " + rossiCount.getBalance() + "]\n");
        bianchiCount.deposit(2, 10000);
        bianchiCount.chargeManagementFees(2);
        System.out.println("[Bianchi: " + bianchiCount.getBalance() + "]\n");

        //12 Nell'account di rossi non succede nulla mentre per quello di bianchi cambia l'ammontare
    }
}
