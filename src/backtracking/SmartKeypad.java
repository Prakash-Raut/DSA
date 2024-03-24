package backtracking;

import java.util.ArrayList;

public class SmartKeypad {

    public static ArrayList<String> smartKeypad(String s) {
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ans = new ArrayList<>();
        smartKeypadHelper(s, keypad, 0, ans, "");
        return ans;
    }

    private static void smartKeypadHelper(String s, String[] keypad, int index, ArrayList<String> ans, String curr) {
        if (index == s.length()) {
            ans.add(curr);
            return;
        }
        int keypadNumber = s.charAt(index) - '0';
        String keypadString = keypad[keypadNumber];

        for (int i = 0; i < keypadString.length(); i++) {
            smartKeypadHelper(s, keypad, index + 1, ans, curr + keypadString.charAt(i));
        }
    }

    public static void main(String[] args) {
        String s = "23";
        System.out.println("smartKeypad(s) = " + smartKeypad(s));
    }
}
