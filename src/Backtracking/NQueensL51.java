package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensL51 {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        int mat[][] = new int[n][n];
        boolean diag1[] = new boolean[n+n-1];
        boolean diag2[] = new boolean[n+n-1];
        boolean column[] = new boolean[n];

        nQueens(mat, diag1, diag2, column, 0, n);
        return ans;
    }

    public void nQueens(int[][] mat, boolean[] diag1, boolean diag2[], boolean column[], int row, int n){

        if(row==n){
            ArrayList<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                String str = "";
                for(int j=0; j<mat[0].length; j++){
                    if(mat[i][j]==1){
                        str="Q"+str;
                    }else{
                        str='.'+str;
                    }
                }
                temp.add(str);
            }
            ans.add(temp);
        }

        for(int col=0; col<n; col++){
            if(column[col]==false && diag1[row-col+mat.length-1]==false && diag2[col+row]==false){
                mat[row][col] = 1;
                diag1[row-col+mat.length-1] = true;
                diag2[col+row] = true;
                column[col] = true;
                nQueens(mat, diag1,diag2, column, row+1,n);
                mat[row][col] = 0;
                diag1[row-col+mat.length-1] = false;
                diag2[col+row] = false;
                column[col] = false;
            }
        }
    }
}
