package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        //1-3
        AccountHolder andreaR = new AccountHolder("Andrea", "Rossi", 1);
        System.out.println(andreaR.toString());

        AccountHolder alexB = new AccountHolder("Alex", "Bianchi", 2);
        System.out.println(alexB.toString());

        SimpleBankAccount countRossi = new SimpleBankAccount(1, 0);
        SimpleBankAccount countBianchi = new SimpleBankAccount(2, 0);

        //4
        countBianchi.deposit(2, 200);
        countBianchi.withdrawFromATM(2, 100);

        countRossi.deposit(1, 300);
        countRossi.withdrawFromATM(1, 100);

        //5
        System.out.println(countBianchi.getBalance());
        System.out.println(countRossi.getBalance());

        //6
        countBianchi.deposit(1, 2000);
        countRossi.deposit(2, 2000);

        //7
        System.out.println(countBianchi.getBalance());
        System.out.println(countRossi.getBalance());
    }
}
