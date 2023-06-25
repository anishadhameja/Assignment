package loops;

import java.util.Scanner;

public class Student {
    int marks;
    String name, grade;

    // parametrized constructor
    public Student(String name, int marks){
        this.name =  name;
        this.marks = marks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students:");
        int numberOfStudents = sc.nextInt();

        // array of students
        Student[] students = new Student[numberOfStudents];

        // This loop takes user input and creates objects
        for(int i=0;i<numberOfStudents;i++){
            System.out.print("Enter name of student "+(i+1)+":");
            String name = sc.next();
            System.out.print("Enter marks of student "+(i+1)+":");
            int marks = sc.nextInt();
            Student s = new Student(name, marks);
            students[i] = s;
        }

        int highestMarks = 0;
        Student studentWithHighestScore=null;

        // This for each loop finds the student with highest marks and also assigns grades based on marks
        for(Student s : students){
            if(s.marks > highestMarks) {
                highestMarks = s.marks;
                studentWithHighestScore = s;
            }
            switch(s.marks/10){
                case 10:
                case 9:
                    s.grade = "A";break;
                case 8:
                    s.grade = "B";break;
                case 7:
                    s.grade = "C";break;
                case 6:
                    s.grade = "D";break;
                case 5:
                    s.grade = "E";break;
                default:
                    s.grade = "F";break;
            }
        }
        System.out.println(studentWithHighestScore.name + " has scored the hisgest marks " + studentWithHighestScore.marks);
        for(Student s : students){
            System.out.println(s.name + " with marks " + s.marks + " has scored " + s.grade + " grade.");
        }
    }
}
