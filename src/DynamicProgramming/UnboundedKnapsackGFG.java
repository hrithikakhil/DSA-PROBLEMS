package DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsackGFG {
    static int knapSack(int N, int W, int val[], int wt[]) {
        // code here
        int dp[][] = new int[N+1][W+1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        return helper(N, W, val, wt, dp);
    }

    static int helper(int i, int cap, int val[], int wt[], int dp[][]){
        if(i==0 || cap==0){
            return 0;
        }

        if(dp[i][cap]!=-1){
            return dp[i][cap];
        }

        int pick = Integer.MIN_VALUE;
        if(wt[i-1]<=cap){
            pick = val[i-1] + helper(i, cap-wt[i-1], val, wt, dp);
        }
        int notPick = helper(i-1, cap, val, wt, dp);

        dp[i][cap] = Math.max(pick, notPick);
        return dp[i][cap];
    }
}
