package recursion;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeHelper(String s, int l, int r) {
        // even: l > r  | odd : l == r
        if (l >= r) return true;
        // check for extreme match
        if (s.charAt(l) == s.charAt(r)) {
            return isPalindromeHelper(s, l + 1, r - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println("isPalindrome(s) = " + isPalindrome(s));
    }
}
