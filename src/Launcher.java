import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        System.out.println("Hello World");
        
        var scanner = new Scanner(System.in);
        String entry = scanner.nextLine();

        if (entry.equals("exit")) {
            System.exit(0);
        } else {
            System.out.println("Unknown command");
        }
    }
}
