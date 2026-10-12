import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String FILEPATH = "output.txt";
        Scanner sc = new Scanner(System.in);
        String input;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH))) {
            System.out.println("Enter text lines below. Type 'EXIT' to finish.");
            while (true) {
                System.out.print("> ");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("EXIT")) {
                    break;
                }
                writer.write(input);
                writer.newLine();
            }
            System.out.println("Data successfully saved to " + FILEPATH);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }

        System.out.println("\nReading file contents");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            sc.close();
        }

        FilterEvents();
    }

    static void FilterEvents(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).toList();

        System.out.println("\nNow filtering even numbers");
        System.out.println("Even numbers: " + evens);
    }
}
