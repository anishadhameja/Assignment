package inheritance;

// This example shows hierarchical inheritance
class Shape {
    double x, y;
    Shape(double x1, double y1){
        x = x1;
        y = y1;
    }
    double area(){
        System.out.println("Area undefined");
        return 0;
    }
}

class Rectangle extends Shape{
    Rectangle(double x1, double y1){
        super(x1,y1);
    }
    // method overriding
    double area(){
        return x*y;
    }
}

class Triangle extends Shape{
    Triangle(double x1, double y1){
        super(x1,y1);
    }

    // method overriding
    double area(){
        return 0.5 * x * y;
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        // Dynamic method dispatch
        Shape rectangle = new Rectangle(1,2);
        Shape triangle = new Triangle(3,5);
        System.out.println(rectangle.area());
        System.out.println(triangle.area());
    }
}
