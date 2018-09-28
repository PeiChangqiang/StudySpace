package com.pcq.type;


abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

     public abstract String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Rhomboid extends Shape {

    @Override
    public String toString() {
        return "Rhomboid";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "Square";
    }
}


class Triangle extends Shape {

    @Override
    public String toString() {
        return "Triangle";
    }
}