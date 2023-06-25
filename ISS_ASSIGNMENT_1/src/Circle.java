import java.util.*;

public class Circle {
    final double PI = 3.14;
    int radius;

    // default constructor
    Circle(){
        radius = 0;
    }

    // parametrized constructor
    Circle(int r){
        radius = r;
    }

    // instance method
    public double calculateArea(){
        return this.radius * PI;
    }

    // static method
    static void display(){
        System.out.println("Static methods can be called without creating objects.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of circle:");
        Circle c1 = new Circle(sc.nextInt());
        System.out.println("Area of circle is "+ c1.calculateArea());

        display();
    }
}
