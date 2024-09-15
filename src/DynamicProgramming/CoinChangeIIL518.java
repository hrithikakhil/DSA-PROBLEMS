package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeIIL518 {
    // This problem is same as Count partitions with given difference
    // s1 - s2 = T where s1>s2, s1 can also be written as => s1= totalSum - s2
    // totalSum -s2 -s2 = T // after deducing this nothing but s2 = (totalSum - target)/2
    // Edge cases 1 totalsum - target should always be greater than 0;
    // Edge case 2 s2 = (totalSum - target)/2 here s2 should be even
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }

        int s2 = sum - target;
        if(s2<0){
            return 0;
        }else if(s2%2!=0){
            return 0;
        }

        int dp[][] = new int[n][(s2/2)+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return findTotalWays(n-1, dp, nums, s2/2);
    }

    // This below code remains same for both Count Partitions with Given Difference and Count Subsets with Sum K
    public int findTotalWays(int i, int[][] dp, int[] nums, int target){
        if(i==0){
            if(nums[0]==0 && target==0){
                return 2;
            }

            if(target==0 || nums[0]==target){
                return 1;
            }

            return 0;
        }

        if(dp[i][target]!=-1){
            return dp[i][target];
        }

        int pick = 0;
        if(target>=nums[i]){
            pick = findTotalWays(i-1, dp, nums, target-nums[i]);
        }
        int dontPick = findTotalWays(i-1, dp, nums, target);

        dp[i][target] = pick+dontPick;
        return dp[i][target];
    }
}
