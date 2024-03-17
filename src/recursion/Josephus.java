package recursion;

public class Josephus {
    /**
     * Finds the survivor's position in the Josephus problem
     * with n people and elimination every kth person.
     *
     * @param n The number of people initially present.
     * @param k The count of persons to be skipped before elimination.
     * @return The position of the survivor.
     */

    public static int josephus(int n, int k) {
        if (n == 1) return 0;
        return (josephus(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        System.out.println("josephus(3,2) = " + josephus(3, 2));
    }

}
