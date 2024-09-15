package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class TriangleSumL120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return findSum(n, 0, 0, dp, triangle);
    }

    public int findSum(int n, int i, int j, int dp[][], List<List<Integer>> triangle){
        if(i==n-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int down = triangle.get(i).get(j) + findSum(n, i+1, j, dp, triangle);
        int diagonal = triangle.get(i).get(j) + findSum(n, i+1, j+1, dp, triangle);

        dp[i][j] = Math.min(down, diagonal);
        return dp[i][j];
    }
}
