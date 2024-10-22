import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        scanner.nextLine();

        if (scanner.hasNext("quit")) {
            System.exit(0);
        }
        else {
            System.out.println("Unknown command");
        }
    }
}
