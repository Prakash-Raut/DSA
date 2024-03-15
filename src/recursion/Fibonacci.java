package recursion;

public class Fibonacci {
    public static int findFibonacci(int n) {
        // Base case: if n is 0 or 1, return n
        if (n <= 1) return n;
        // Recursively find the (n-1)th Fibonacci number
        int previousFibonacci = findFibonacci(n - 1);
        // Recursively find the (n-2)th Fibonacci number
        int previousPreviousFibonacci = findFibonacci(n - 2);
        // Add the (n-1)th and (n-2)th Fibonacci numbers to get the nth Fibonacci number
        return previousFibonacci + previousPreviousFibonacci;
    }

    public static void main(String[] args) {
        System.out.println("findFibonacci(5) = " + findFibonacci(5));
    }
}
