package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetL78 {
    List<List<Integer>> sets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        generate_subsets(0, nums, ans);
        return sets;
    }

    public void generate_subsets(int idx, int[] nums, ArrayList<Integer> ans){

        if(idx==nums.length){
            sets.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[idx]);
        generate_subsets(idx+1, nums, ans);
        ans.remove(ans.size()-1);
        generate_subsets(idx+1, nums, ans);
    }
}
