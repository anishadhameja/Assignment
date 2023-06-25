package collection;

import java.util.*;

public class StudentCollection {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet();
        List<Student> list = new ArrayList<>();
        HashMap<Integer,Student> map = new HashMap<>();

        Student s2 = new Student(2, "Riya");
        Student s1 = new Student(1, "Anisha");
        Student s3 = new Student(3, "Diya");
        Student s4 = new Student(1, "Khushboo");

        set.addAll(Arrays.asList(s1,s2,s3,s4));
        System.out.println(set);

        list.addAll(Arrays.asList(s2,s1,s3,s4));
        System.out.println(list);

        // method 1: comparator as a lambda method
        list.sort((o1,o2)-> o1.roll_number - o2.roll_number); // sorting based on roll numbers
        System.out.println(list);

        // method 2: implementing comparable in Student class
        Collections.sort(list); // sorting based on names
        System.out.println(list);

        // method 3: sorting list with comparator
        Collections.sort(list, new RollComparator()); // sorting based on roll numbers
        System.out.println(list);

        map.put(s1.roll_number, s1);
        map.put(s2.roll_number, s2);
        map.put(s3.roll_number, s3);
        map.put(s4.roll_number, s4);

        System.out.println(map);
    }
}
