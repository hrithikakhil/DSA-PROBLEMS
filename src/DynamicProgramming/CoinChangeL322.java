package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeL322 {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int t = amount;

        int dp[][] = new int[n+1][t+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }


        int ans = findCoins(coins, amount, n, dp);
        if(ans>=(int)1e9){
            return -1;
        }

        return ans;

    }

    public int findCoins(int[] coins, int amount, int idx, int[][]dp){
        if(idx==0){
            return (int)1e9;
        }

        if(amount==0){
            return 0;
        }

        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }

        int take = (int)1e9;
        if(coins[idx-1]<=amount){
            take = 1 + findCoins(coins, amount-coins[idx-1], idx, dp);
        }
        int nottake = findCoins(coins, amount, idx-1, dp);
        dp[idx][amount] = Math.min(take, nottake);
        return dp[idx][amount];
    }
}
