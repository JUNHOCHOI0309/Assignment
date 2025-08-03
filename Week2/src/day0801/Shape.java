package day0801;

public class Shape { // 과제 1
    String name;

    public Shape(String name) {
        this.name = name;
    }

    public void printInfo(){}

    public void area(){
        System.out.println("area");
    }
    public void area(int a){
        System.out.println("circle area :"+a*a*3.14);
    }
    public void area(int a, int b){
        System.out.println("rectangle area :"+a*b);
    }
    public void area(double a, double b, double c){
        System.out.println("triangle area :"+a*b*c/2);
    }
    public static void main(String[] args) {
        Shape s1 = new Circle("circle");
        Shape s2 = new Rectangle("rectangle");
        Shape s3 = new Triangle("triangle");

        s1.printInfo();
        s2.printInfo();
        s3.printInfo();

        s1.area();
        s1.area(10);
        s1.area(10, 20);
        s1.area(10, 20, 30);
    }
}

class Circle extends Shape {
    public Circle(String name) {
        super(name);
    }
    public void printInfo(){
        System.out.println("This is a circle");
    }
}

class Rectangle extends Shape {
    public Rectangle(String name) {
        super(name);
    }
    public void printInfo(){
        System.out.println("This is a rectangle");
    }
}
class Triangle extends Shape {
    public Triangle(String name) {
        super(name);
    }
    public void printInfo(){
        System.out.println("This is a triangle");
    }
}



