package DynamicProgramming;

import java.util.Arrays;

public class MinPathSumL64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        return findSum(grid, n-1, m-1, dp);
    }

    public int findSum(int[][] grid, int i, int j, int[][] dp){
        if(i==0 && j==0){
            return grid[i][j];
        }

        if(i<0 || j<0){
            return (int)1e9;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up = grid[i][j] + findSum(grid, i-1, j, dp);
        int left = grid[i][j] + findSum(grid, i, j-1, dp);

        dp[i][j] = Math.min(up, left);
        return dp[i][j];
    }
}
