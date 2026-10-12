public class Main {
    public static void main(String[] args) {
        for (GradeLevel level : GradeLevel.values()) {
            System.out.printf("Level: %s | Can Graduate: %s%n", level, level.canGraduate());
        }

        System.out.println("|| Automatic getters ||");
        StudentRecord record1 = new StudentRecord("Kingstone", 123, 3.9);
        StudentRecord record2 = new StudentRecord("Alice", 101, 2.4);
        StudentRecord record3 = new StudentRecord("Alice", 101, 2.4);
        System.out.println("Student's name: " + record1.name()); //didn't need to manually write getter
        System.out.println("Student's ID: " + record1.id());
        System.out.println("Student's GPA: " + record1.gpa());
        System.out.println("Student's name: " + record2.name()); //didn't need to manually write getter
        System.out.println("Student's ID: " + record2.id());
        System.out.println("Student's GPA: " + record2.gpa());
        System.out.println();
        System.out.println("Auto-generated toString()");
        System.out.println(record1);
        System.out.println(record2);
        System.out.println();
        System.out.println("Auto-generated hashCode()");
        System.out.println("Student 1 HashCode: " + record1.hashCode());
        System.out.println("Student 2 HashCode: " + record2.hashCode());
        System.out.println("Student 3 HashCode: " + record3.hashCode()); //same hash code because it has the same data as record 2
        System.out.println();
        System.out.println("Auto-generated equals()");
        System.out.println("Does record1 have the same data as record2?: " + record1.equals(record2));
        System.out.println("Does record2 have the same data as record3?: " + record2.equals(record3));
    }
}
