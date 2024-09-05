package Arrays;

public class SetMatrixZeroesL73 {

    public void setZeroes(int[][] matrix) {

        // 1. first we will traverse the 0th row and 0th column of the given matrix and if we encounter any 0 then we will set
        //the isRow0/isCol0 variable to true which indicates that the 0th row/0th column of the given matrix will become 0

        // 2. next we will traverse the remaining matrix except 0th row and 0th column and if we encounter any 0,
        //we will make the corresponding row no. and column no. equal to 0 in the 0th column and 0th row respectively

        // 3. Now we will update the values of the matrix except first row and first column to 0 if matrix[i][0]=0
        //or matrix[0][j]=0 for any (i,j).

        // 4. finally we will traverse the 0th row and 0th column and if we find any 0,
        //we will make the whole row and whole column equal to 0

        // TC - O(MN) & SC = O(1)

        int n = matrix.length;
        int m = matrix[0].length;

        boolean isRow0 = false, isCol0 = false;

        for(int i=0; i<n; i++){
            if(matrix[i][0]==0){
                isCol0 = true;
            }
        }

        for(int j=0; j<m; j++){
            if(matrix[0][j]==0){
                isRow0 = true;
            }
        }


        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(isRow0){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }

        if(isCol0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }

    }
}
