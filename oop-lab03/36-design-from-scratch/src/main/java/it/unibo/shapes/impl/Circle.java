package it.unibo.shapes.impl;

import it.unibo.shapes.api.Shape;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public double getPerimeter() {
        return this.radius * Math.PI * 2;
    }

    public String toString(){
        return "Circle: [ raggio= " + this.radius + ", perimetro= " + this.getPerimeter() 
        + ", area= " + this.getArea() + "]\n";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
