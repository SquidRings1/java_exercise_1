import java.util.Scanner;

public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter a number");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println(Fibonacci(n));
        return true;
    }
}
