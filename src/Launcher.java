import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        System.out.println("Hello World");
        String actual_path = System.getProperty("user.dir");
        System.out.println("Current directory: " + actual_path);

        var scanner = new Scanner(System.in);

        for (;;) {
            String entry = scanner.nextLine();
            if (entry.equals("quit")) {
                scanner.close();
                break;
            } else if (entry.equals("fibo")) {
                System.out.println("Enter a number");
                int n = scanner.nextInt();
                Fibonacci fib = new Fibonacci(n);
                System.out.println(fib.execute_fibonacci(n));
                break;
            } else if (entry.equals("freq")) {
                System.out.print("Please enter the file path: ");
                String filePath = scanner.nextLine();
                Freq freq = new Freq(filePath);
                freq.execute_freq();
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
