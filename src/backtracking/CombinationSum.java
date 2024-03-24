package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, ans, curr, 0);
        return ans;
    }

    private static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> curr, int index) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            curr.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], ans, curr, i + 1);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {8, 1, 3, 7, 2, 1, 5};
        int target = 12;

        List<List<Integer>> ans = combinationSum(candidates, target);

        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
