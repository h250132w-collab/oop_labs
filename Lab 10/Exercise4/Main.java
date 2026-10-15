import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Student> students = List.of(
                new Student("Kingstone", 78.5),
                new Student("Alice", 91.0),
                new Student("Danny", 55.0),
                new Student("Bob", 67.5),
                new Student("Sasha", 84.0)
        );

        double average = students.stream().mapToDouble(Student::marks).average().orElse(0.0);
        System.out.println("Class average: " + average);

        List<String> aboveAverage = students.stream()
                .filter(s -> s.marks() > average)
                .map(Student::name)
                .sorted()
                .toList();

        System.out.println("Above average: " + aboveAverage);
    }
}
