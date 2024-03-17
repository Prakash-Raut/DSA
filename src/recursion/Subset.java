package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {
    public static List<String> findSubstrings(String s) {
        List<String> res = new ArrayList<>();
        findSubstringsHelper(s, 0, "", res);
        res.remove("");
        Collections.sort(res);
        return res;
    }

    private static void findSubstringsHelper(String s, int i, String curr, List<String> res) {
        if (i == s.length()) {
            res.add(curr);
            return;
        }
        // Include the current character
        findSubstringsHelper(s, i + 1, curr + s.charAt(i), res);

        // Exclude the current character
        findSubstringsHelper(s, i + 1, curr, res);
    }

    public static void main(String[] args) {
        System.out.println("findSubstrings(\"abc\") = " + findSubstrings("abc"));
    }
}
