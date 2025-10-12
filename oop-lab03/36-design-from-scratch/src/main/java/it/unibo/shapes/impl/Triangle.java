package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Triangle implements Polygon{
    private static final int EDGES = 3;

    private double base;
    private double lato1;
    private double lato2;
    private double altezza;

    public Triangle(double base, double lato1, double lato2, double altezza){
        this.base = base;
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.altezza = altezza;
    }

    public double getArea() {
        return (this.base * this.altezza)/2;
    }

    
    public double getPerimeter() {
      return base + lato1 + lato2;
    }

    
    public int getEdgeCount() {
        return EDGES;
    }


    public String toString() {
        return "Triangle [base=" + base + ", lato1=" + lato1 + ", lato2=" + lato2 + ", altezza=" + altezza
                + ", getArea()=" + getArea() + ", getPerimeter()=" + getPerimeter() + ", getEdgeCount()="
                + getEdgeCount() + "]\n";
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getLato1() {
        return lato1;
    }

    public void setLato1(double lato1) {
        this.lato1 = lato1;
    }

    public double getLato2() {
        return lato2;
    }

    public void setLato2(double lato2) {
        this.lato2 = lato2;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }
    
}
