import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStats {
    public static void main(String[] args){
        final String FILEPATH = "sample.txt";
        int lines = 0;
        int words = 0;
        int characters = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
            String line;
            while ((line = reader.readLine()) != null){
                lines++;
                characters += line.length();
                if (!line.trim().isEmpty()){
                    words += line.trim().split("\\s+").length;
                }
            }
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + characters);
        } catch (IOException e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
