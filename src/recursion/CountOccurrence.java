package recursion;

public class CountOccurrence {
    public static int countOccurrenceInString(String s, String t) {
        return countOccurrenceInStringHelper(s, t, 0);
    }

    public static int countOccurrenceInStringHelper(String s, String t, int i) {
        // Base case: if the index exceeds the limit, return 0.
        int limit = s.length() + t.length();
        if (i >= limit) return 0;
        // Recursive call to solve smaller sub-problems.
        int subProblem = countOccurrenceInStringHelper(s, t, i + 1);
        // Check if the substring starting from index 'i' in 's' matches "t".
        boolean isStartingCharsMatching = s.startsWith(t, i);
        // If starting characters match, increment the count.
        if (isStartingCharsMatching) return subProblem + 1;
        // No match, return the count as it is.
        else return subProblem;
    }

    public static void main(String[] args) {
        String s = "hello world, hello universe", t = "hello";
        System.out.println("countOccurrenceInString(s,t) = " + countOccurrenceInString(s, t));
    }
}
