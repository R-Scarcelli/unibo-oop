public class Calculator {
    int nOpDone = 0;
    Double lastRes;

    double add(Double num1, Double num2) {
        lastRes = num1 + num2;
        this.nOpDone++;
        return lastRes;
    }

    double sub(Double num1, Double num2) {
        lastRes = num1 - num2;
        this.nOpDone++;
        return lastRes;
    }

    double mul(Double num1, Double num2){
        lastRes = num1 * num2;
        this.nOpDone++;
        return lastRes;
    }
    
    double div(Double num1, Double num2){
        lastRes = num1 / num2;
        this.nOpDone++;
        return lastRes;
    }
}
