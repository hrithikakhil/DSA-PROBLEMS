package DynamicProgramming;

import java.util.Arrays;

public class ClimbStairsL70 {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return findWays(n, dp);
    }

    public int findWays(int n, int[] dp){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n] = findWays(n-1, dp) + findWays(n-2, dp);
        return dp[n];
    }
}
