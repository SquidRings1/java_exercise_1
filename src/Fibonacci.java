public class Fibonacci {
    public int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public int execute_fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return execute_fibonacci(n - 1) + execute_fibonacci(n - 2);
    }
}
