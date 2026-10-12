import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<String> students = new ArrayList<>();
        studentNames.add("Alice");
        studentNames.add("Bob");
        studentNames.add("Ben");
        studentNames.add("Danny");
        studentNames.add("Sasha");

        //setting at index 2
        studentNames.add(2, "Eileen");

        //removing by name
        studentNames.remove("Ben");

        //replace at index 0
        studentNames.set(0, "Trish");

        for (String name : studentNames){
            System.out.println(name);
        }

        Set<String> items = new HashSet<>();
        items.add("goofy");
        items.add("goofy");
        items.add("bun");
        items.add("bun");
        items.add("abc");
        items.add("abc");

        System.out.println(items); //duplicates will be ignored

        List<String> sortedItems = new ArrayList<>(items);
        Collections.sort(sortedItems);
        System.out.println(sortedItems); //sorted list will be printed
    }
}
