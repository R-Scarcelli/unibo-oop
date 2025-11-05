package it.unibo.constructors;

class UseConstructorsEvolved {

    public static void main(final String[] args) {
        // 1) Creare un treno con numero di posti di default, come nel caso
        // precedente (serve a verificare la nuova implementazione di Train()).
        Train defTrain = new Train();
        defTrain.printTrainInfo();
        System.out.println("firstTrain Total seat correct?" + (defTrain.getTotalSeats() == defTrain.getFirstClassSeats() + defTrain.getSecondClassSeats()) + "]\n");

        // 2) Creare i seguenti treni usando il costruttore Train(int nFCSeats, int
        // nSCSeats)
        // - nFCSeats = 20; nSCSeats= 200;
        // - nFCSeats = 35; nSCSeats= 165;
        Train firstTrain = new Train(20, 200);
        firstTrain.printTrainInfo();
        System.out.println("firstTrain Total seat correct?" + (firstTrain.getTotalSeats() == firstTrain.getFirstClassSeats() + firstTrain.getSecondClassSeats()) + "]\n");

        Train secondTrain = new Train(100, 200);
        firstTrain.printTrainInfo();
        System.out.println("firstTrain Total seat correct?" + (secondTrain.getTotalSeats() == secondTrain.getFirstClassSeats() + secondTrain.getSecondClassSeats()) + "]\n");


    }
}
