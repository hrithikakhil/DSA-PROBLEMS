package DynamicProgramming;

import java.util.Arrays;

public class MinPathFallingSumL931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -101);
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<m; j++){
            ans = Math.min(fallingSum(matrix, 0, j, dp), ans);
        }
        return ans;
    }

    public int fallingSum(int[][] matrix, int i, int j, int[][] dp){
        int n = matrix.length;
        int m = matrix[0].length;
        if(i>n-1 || j<0 || j>m-1){
            return (int)1e9;
        }

        if(i==n-1){
            return matrix[i][j];
        }

        if(dp[i][j]!=-101){
            return dp[i][j];
        }

        int down = matrix[i][j] + fallingSum(matrix, i+1, j, dp);
        int leftdowndiag = matrix[i][j] + fallingSum(matrix, i+1, j-1, dp);
        int rightdowndiag = matrix[i][j] + fallingSum(matrix, i+1, j+1, dp);

        dp[i][j] = Math.min(Math.min(down, leftdowndiag), rightdowndiag);
        return dp[i][j];
    }
}
