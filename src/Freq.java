import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Freq {
    private String path;
    private Path the_path;

    public Freq(String path) {
        this.path = path;
    }

    public void execute_freq() {
        try {
            this.the_path = Paths.get(this.path);
            System.out.println("File path: " + this.the_path);
            String content = Files.readString(this.the_path, java.nio.charset.StandardCharsets.UTF_8);
            //System.out.println(content);
            // THE REGEX PARSER btw I hate regex
            String[] lines = content.toLowerCase().replaceAll("\\p{Punct}", " ").split("\n");
            Arrays.stream(lines)
                    .flatMap(line -> Arrays.stream(line.trim().split("\\s+")))
                    .filter(word -> !word.isBlank())
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry::getKey))
                    .limit(3)
                    .forEach(entry -> System.out.print(entry.getKey() + " "));
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getClass().getName() + " - " + e.getMessage());
        }
    }
}
