package Backtracking;

public class SudokuSolverL37 {
    public void solveSudoku(char[][] board) {

        solve(board);
    }

    public boolean solve(char[][] board){

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){ //First step check if the cell is empty
                    for(char c='1'; c<='9'; c++){ // if the cell is empty run a loop to check the if the number is valid to be placed in the current cell
                        if(isValid(i,j,c,board)){ // check for validity
                            board[i][j] = c; // if the number is valid place it in the board and call the board function again
                            if(solve(board)==true){ // if solve fun return true, then return true
                                return true;
                            }else{ // if not true then it means that the number is not valid for a cell, hence remove the number
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false; // if none of the number is valid return false;
                }
            }
        }
        return true; //if all the cells are valid return true;

    }

    public boolean isValid(int row, int col, char c, char[][] board){
        for(int i=0; i<9; i++){
            if(board[i][col]==c){ // check for the row
                return false;
            }
            if(board[row][i]==c){ // check for the col
                return false;
            }

            // Check for 3*3 matrix also
            int m = 3*(row/3)+i/3;
            int n = 3*(col/3)+i%3;
            if(board[m][n]==c){
                return false;
            }
        }
        return true;
    }
}
