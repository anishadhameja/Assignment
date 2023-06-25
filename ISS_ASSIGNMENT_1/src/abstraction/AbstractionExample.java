package abstraction;

abstract class Operation {
    abstract void calculate(int a, int b);
}

class Addition extends Operation {
    void calculate (int p, int q){
        System.out.println("Addition is "+ (p+q));
    }
}

class Subtraction extends Operation {
    void calculate(int p, int q){
        System.out.println("Subtraction is "+ (p-q));
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Operation operation = new Addition();
        operation.calculate(5,3);
        operation = new Subtraction();
        operation.calculate(5,3);
    }
}
