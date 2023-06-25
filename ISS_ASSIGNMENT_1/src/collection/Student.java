package collection;

import java.util.*;

public class Student implements Comparable<Student> {
    int roll_number;
    String name;

    Student(int roll, String name){
        roll_number = roll;
        this.name = name;
    }

    @Override
    public int hashCode(){
        return roll_number;
    }

    @Override
    public boolean equals(Object o) {
        Student s = (Student) o;
        return s.roll_number == roll_number;
    }

    public String toString(){
        return roll_number+" "+name;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}


class RollComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.roll_number - s2.roll_number;
    }
}