package com.pcq.type;

import java.util.Arrays;
import java.util.List;

public class Shapes {
    public static void main(String[] args) {
        List<Shape> list = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
        for (Shape shape : list) {
            shape.draw();
        }

        Shape shape = new Rhomboid();
        Rhomboid r = (Rhomboid) shape;
        if(shape instanceof Circle) {
            Circle c = (Circle) shape;
        } else {
            System.out.println("shape is not a Circle");
        }

    }
}
