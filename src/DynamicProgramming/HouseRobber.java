package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return findMaxSum(nums.length-1, nums, dp);
    }

    public int findMaxSum(int idx, int[] nums, int[] dp){
        if(idx==0){
            return nums[idx];
        }

        if(idx<0){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int include = nums[idx] + findMaxSum(idx-2, nums, dp);
        int exclude = findMaxSum(idx-1, nums, dp);

        dp[idx] = Math.max(include, exclude);
        return dp[idx];
    }
}
