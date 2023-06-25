package packagehandling.p1;

public class Maths {
    public boolean isPrime(int number){
        for(int i=2;i<number/2;i++){
            if(i%number == 0)
                return false;
        }
        return true;
    }
    public boolean isEven(int number){
        return number % 2 == 0;
    }
    public int sumOfDigits(int number){
        int sum = 0;
        while(number!=0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
}
