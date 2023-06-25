// class
public class Student {
    // instance variables
    private String name;
    private int marks;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public void showInformation(){
        System.out.println(this.name +" has scored "+ this.marks + " marks.");
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setName("Anisha");
        s1.setMarks(90);
        s2.setName("Riya");
        s2.setMarks(80);
        s1.showInformation();
        s2.showInformation();
    }
}
