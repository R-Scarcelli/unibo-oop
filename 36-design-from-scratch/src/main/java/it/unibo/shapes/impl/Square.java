package it.unibo.shapes.impl;

import it.unibo.shapes.api.Polygon;

public class Square implements Polygon{
    private static final int EDGES = 4;

    private double edge;

    public Square(double edge){
        this.edge = edge;
    }
    
    public double getArea() {
        return Math.pow(edge, 2);
    }

    public double getPerimeter() {
        return this.edge * EDGES;
    }

    public int getEdgeCount() {
        return EDGES;
    }

    public String toString() {
        return "Square [edge=" + edge + ", getArea()=" + getArea() + ", getPerimeter()=" + getPerimeter()
                + ", getEdgeCount()=" + getEdgeCount() + "]\n";
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

}
