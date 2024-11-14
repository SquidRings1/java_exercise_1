import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Freq implements Command {
    private String path;
    private Path the_path;

    @Override
    public String name() {
        return "freq";
    }

    public void execute_freq(String path) {
        try {
            this.the_path = Paths.get(this.path);
            System.out.println("File path: " + this.the_path);
            String content = Files.readString(this.the_path, java.nio.charset.StandardCharsets.UTF_8);
            //System.out.println(content);
            /*
             THE REGEX PARSER btw I hate regex doing python and regex for like 1 month during internship.....
             */
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
            System.out.println("Unreadable file: " + e.getClass().getName() + " - " + e.getMessage());
        }
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.print("Please enter the file path: ");
        String filePath = scanner.nextLine();
        this.path = filePath;
        execute_freq(path);
        return true;
    }
}
