package HashMaps;

import java.util.HashMap;

public class TwoSumL01 {

    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int x = target - nums[i];
            if(map.containsKey(x)){
                int ii = map.get(x);
                int jj = i;
                return new int[] {ii, jj};
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}
