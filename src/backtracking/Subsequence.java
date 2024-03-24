package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subsequence {

    public static ArrayList<ArrayList<Integer>> allSubsets(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Collections.sort(nums);
        subsetsHelper(nums, ans, curr, 0);
        return ans;
    }

    private static void subsetsHelper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> ans,  ArrayList<Integer> curr, int index) {
        ans.add(new ArrayList<>(curr));
        for (int i = index; i < nums.size(); i++) {
            if (i > index && nums.get(i) == nums.get(i-1)) continue;
            curr.add(nums.get(i));
            subsetsHelper(nums, ans, curr, i+1);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        ArrayList<ArrayList<Integer>> arrayLists = allSubsets(nums);
        System.out.println(arrayLists);

    }
}
