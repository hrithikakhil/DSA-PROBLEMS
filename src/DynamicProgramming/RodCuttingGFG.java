package DynamicProgramming;

import java.util.Arrays;

public class RodCuttingGFG {
    public int cutRod(int price[], int n) {
        //code here
        int dp[][] = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return helper(n, price, n, dp);
    }

    public int helper(int i, int price[], int len, int[][] dp){
        if(i==0 || len==0){
            return 0;
        }

        if(dp[i][len]!=-1){
            return dp[i][len];
        }

        int pick = Integer.MIN_VALUE;
        if(i <= len){
            pick = price[i-1] + helper(i, price, len-i, dp);
        }
        int notPick = helper(i-1, price, len, dp);

        dp[i][len] = Math.max(pick, notPick);

        return dp[i][len];
    }
}
