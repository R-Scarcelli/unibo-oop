package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Rectangle implements Polygon{
    private static final int EDGES = 4;

    private double base;
    private double altezza;
    
    public Rectangle(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getArea() {
        return this.base * this.altezza;
    }

    public double getPerimeter() {
        return (this.base * 2) + (this.altezza * 2);
    }

    @Override
    public int getEdgeCount() {
        return EDGES;
    }

    @Override
    public String toString() {
        return "Rectangle [base=" + base + ", altezza=" + altezza + ", getArea()=" + getArea() + ", getPerimeter()="
                + getPerimeter() + ", getEdgeCount()=" + getEdgeCount() + "]\n";
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }
    
}
