class ComplexNum {
    /*
     * Inserire qui la dichiarazione dei campi della classe
     */
    Double re;
    Double im;

    void build(double re, double im) {
        /*
         * Inserire qui l'inizializzazione dei campi con i parametri forniti in input
         */
        this.im = im;
        this.re = re;
    }

    boolean equal(ComplexNum num) {
        /*
         * Implementare il metodo in modo che restituisca true se e solo se il
         * numero complesso è uguale al parametro num passato in input
         */
        return (this.im == num.im) && (this.re == num.re);
    }

    void add(ComplexNum num) {
        /*
         * Implementare il metodo in modo che venga aggiunto il numero complesso
         * passato in input - Rif. Appendice A1 (slide)
         */
        this.re += num.re;
        this.im += num.im;
    }

    String toStringRep() {
        /*
         * Implementare il metodo in modo che restituisca una rappresentazione
         * testuale del numero complesso
         */
        return "[Num: " + this.re + "+" + this.im + "i]";
    }
}