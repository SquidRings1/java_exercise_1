import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        String entry = scanner.nextLine();

        if (entry.equals("exit")) {
            System.exit(0);
        } else {
            System.out.println("Unknown command");
        }
    }
}
