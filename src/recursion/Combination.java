package recursion;

public class Combination {

    public static int nCr(int n, int r) {
        // Base case: if n equals r or r equals 0, return 1
        if (n == r || r == 0) return 1;
        // If r is greater than n, return 0 as it's
        // not possible to choose r elements from n
        if (r > n) return 0;
        // this approach is based on the given formula
        // nCr = (n-1)C(r-1) + (n-1)Cr
        int first = nCr(n - 1, r - 1);
        int second = nCr(n - 1, r);
        return (first + second);
    }

    public static void main(String[] args) {
        System.out.println("nCr(5, 3) = " + nCr(5, 3));
    }
}
