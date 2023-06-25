public class Employee {
    int salary;
    int id;
    String name;

    public void display(){
        System.out.println("Employee "+name+" has ID "+id+" and has a salary "+salary);
    }

    public static void main(String[] args) {
        try {
            Employee emp = null;
            System.out.println(emp.salary/0);
        } catch (NullPointerException e){
            System.out.println("You are trying to access null pointer");
        } catch (ArithmeticException e){
            System.out.println("Divide by zero");
        }
    }
}