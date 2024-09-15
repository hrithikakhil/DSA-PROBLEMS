package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequenceL300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int[] row : dp){
           Arrays.fill(row, -1);
        }
        return findLIS(0, -1, nums, dp);
    }

    public int findLIS(int i, int pi, int nums[], int[][] dp){
        int n = nums.length;
        if(i==n){
            return 0;
        }

        if(dp[i][pi+1]!=-1){
            return dp[i][pi+1];
        }

        int dontPick = findLIS(i+1, pi, nums, dp);
        int pick = 0;
        if(pi==-1 || nums[i]>nums[pi]){
            pick = 1+findLIS(i+1, i, nums, dp);
        }

        dp[i][pi+1] = Math.max(pick, dontPick);
        return dp[i][pi+1];
    }
}
