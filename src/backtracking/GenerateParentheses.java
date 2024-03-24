package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParentheses(int n) {
        ArrayList<String> ans = new ArrayList<>();
        return generateParenthesesHelper("", n, 0, 0, 0, ans);
    }

    private static List<String> generateParenthesesHelper(String curr, int n, int i, int open, int close, ArrayList<String> ans) {
        if (i == 2 * n) {
            ans.add(curr);
        }
        if (open < n) {
            curr = curr + "(";
            generateParenthesesHelper(curr, n, i + 1, open + 1, close, ans);
            curr = curr.substring(0, curr.length() - 1);
        }
        if (close < open) {
            curr = curr + ")";
            generateParenthesesHelper(curr, n, i + 1, open, close + 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("generateParentheses(n) = " + generateParentheses(n));
    }
}
