public class ComplexNumCalculator {
    int nOpDone;
    ComplexNum lastRes;

    void build(){
        this.nOpDone = 0;
        this.lastRes = new ComplexNum();
    }

    ComplexNum add(ComplexNum c1, ComplexNum c2){
        ComplexNum c3 = new ComplexNum();
        c3.build(c1.re + c2.re, c1.im + c2.im);
        lastRes = c3;
        this.nOpDone ++;
        return lastRes;
    }

    ComplexNum sub(ComplexNum c1, ComplexNum c2){
        ComplexNum c3 = new ComplexNum();
        c3.build(c1.re - c2.re, c1.im - c2.im);
        lastRes = c3;
        this.nOpDone ++;
        return lastRes;
    }

    ComplexNum mul(ComplexNum c1, ComplexNum c2){
        ComplexNum c3 = new ComplexNum();
        c3.build(c1.re * c2.re - c1.im * c2.im, c1.im * c2.re +c1.re * c2.im);
        lastRes = c3;
        this.nOpDone ++;
        return lastRes;
    }

    ComplexNum div(ComplexNum c1, ComplexNum c2){
        ComplexNum c3 = new ComplexNum();
        Double re = (c1.re * c2.re + c1.im * c2.im) / (c2.re * c2.re + c2.im * c2.im);
        Double im = (c1.im * c2.re - c1.re * c2.im) / (c2.re * c2.re + c2.im * c2.im);
        c3.build(re, im);
        lastRes = c3;
        this.nOpDone ++;
        return lastRes;
    }
}
