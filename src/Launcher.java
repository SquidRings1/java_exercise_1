import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        System.out.println("Hello World");

        var scanner = new Scanner(System.in);

        while (true) {
            String entry = scanner.nextLine();
            if (entry.equals("quit")) {
                break;
            } else if (entry.equals("fibo")) {
                System.out.println("Enter a number");
                int n = scanner.nextInt();
                Fibonacci fib = new Fibonacci(n);
                System.out.println(fib.execute_fibonacci(n));
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
