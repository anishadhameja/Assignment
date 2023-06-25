package packagehandling.p2;
import packagehandling.p1.*;

public class MathDemo {
    public static void main(String[] args) {
        Maths m = new Maths();
        int number = 123;
        if(m.isPrime(number))
            System.out.println(number+ " is prime.");
        else System.out.println(number+ " is not prime.");
        if(m.isEven(number))
            System.out.println(number+" is even.");
        else System.out.println(number+" is odd.");
        System.out.println("Sum of digits is "+m.sumOfDigits(number));
    }
}
