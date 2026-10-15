import java.util.*;

public class WordFrequency {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String text = sc.nextLine();
        sc.close();

        String[] words = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words){
            if (!word.isEmpty()){
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())){
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return entry2.getValue() - entry1.getValue();
        });

        System.out.println("\nWord frequencies");
        for (Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
