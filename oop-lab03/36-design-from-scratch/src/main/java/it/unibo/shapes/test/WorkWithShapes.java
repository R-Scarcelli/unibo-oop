package it.unibo.shapes.test;

import it.unibo.shapes.impl.Circle;
import it.unibo.shapes.impl.Rectangle;
import it.unibo.shapes.impl.Square;
import it.unibo.shapes.impl.Triangle;

public class WorkWithShapes {
    public static void main(String[] args) {
        //Creo il cerchio
        Circle circle = new Circle(3.7);

        //Creo il triangolo
        Triangle triangle = new Triangle(2, 1.3, 1.2, 2);

        //Creo il quadrato
        Square square = new Square(15);

        //Creo il rettangolo
        Rectangle rectangle = new Rectangle(2,4);

        //Stampo a video perimetro e area delle figure
        System.out.println(circle.toString());
        System.out.println(triangle.toString());
        System.out.println(square.toString());
        System.out.println(rectangle.toString());
    }
}
