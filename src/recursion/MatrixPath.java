package recursion;

public class MatrixPath {

    public static int totalWays(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return totalWays(m - 1, n) + totalWays(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println("totalWays(3,3) = " + totalWays(3, 3));
    }
}
