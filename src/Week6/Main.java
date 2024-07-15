package Week6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student(5, "Student1", "Address0"));
        students.add(new Student(2, "Student2", "Address9"));
        students.add(new Student(8, "Student3", "Address8"));
        students.add(new Student(4, "Student4", "Address7"));
        students.add(new Student(1, "Student5", "Address6"));
        students.add(new Student(10, "Student6", "Address5"));
        students.add(new Student(7, "Student7", "Address4"));
        students.add(new Student(6, "Student8", "Address3"));
        students.add(new Student(9, "Student9", "Address2"));
        students.add(new Student(3, "Student0", "Address1"));

        Main sorter = new Main();

        System.out.println("Unsorted");
        for (Student student : students) {
            System.out.println(student);
        }

        sorter.bubbleSortByRollno(students);
        System.out.println("\nSorted by roll number");
        for (Student student : students) {
            System.out.println(student);
        }

        sorter.bubbleSortByName(students);
        System.out.println("\nSorted by name");
        for (Student student : students) {
            System.out.println(student);
        }

        sorter.bubbleSortByAddress(students);
        System.out.println("\nSorted by address");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void bubbleSortByRollno(ArrayList<Student> students) {
        int n = students.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (students.get(j).rollno > students.get(j+1).rollno) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j+1));
                    students.set(j+1, temp);
                }
            }
        }
    }

    public void bubbleSortByName(ArrayList<Student> students) {
        int n = students.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (students.get(j).name.compareTo(students.get(j+1).name) > 0) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j+1));
                    students.set(j+1, temp);
                }
            }
        }
    }

    public void bubbleSortByAddress(ArrayList<Student> students) {
        int n = students.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (students.get(j).address.compareTo(students.get(j+1).address) > 0) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j+1));
                    students.set(j+1, temp);
                }
            }
        }
    }
}
