package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public static List<List<String>> palindromePartition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        palindromePartitionHelper(s, ans, curr, 0);
        return ans;
    }

    private static void palindromePartitionHelper(String s, List<List<String>> ans, List<String> curr, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));
                palindromePartitionHelper(s, ans, curr, i + 1);
                curr.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "nnwesipil";

        List<List<String>> ans = palindromePartition(s);

        for (List<String> list : ans) {
            System.out.println(list);
        }
    }
}
