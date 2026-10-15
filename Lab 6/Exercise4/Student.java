import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student implements Comparable<Student>{
    private String name;
    private double marks;

    public Student(String name, double marks){
        this.name = name;
        this.marks = marks;
    }

    public String getName(){
        return this.name;
    }

    public double getMarks(){
        return this.marks;
    }

    @Override
    public int compareTo(Student other){
        return this.name.compareTo(other.name);
    }

    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Kingstone", 78.5));
        students.add(new Student("Alice", 91.0));
        students.add(new Student("Danny", 55.0));
        students.add(new Student("Bob", 67.5));

        Collections.sort(students);
        System.out.println("---Sorted by name---");
        for (Student student : students){
            System.out.println(student.getName() + ": " + student.getMarks());
        }

        Collections.sort(students, new MarksComparator());
        System.out.println("---Sorted by marks---");
        for (Student student : students){
            System.out.println(student.getName() + ": " + student.getMarks());
        }
    }
}

class MarksComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2){
        return Double.compare(student1.getMarks(), student2.getMarks());
    }
}
