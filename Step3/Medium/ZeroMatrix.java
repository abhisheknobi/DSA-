package Step3.Medium;

/*
 * Problem Statement: Given a matrix if an element in the matrix is 0
 *  then you will have to set its entire column and row to 0 and then'
 *  return the matrix.

Examples
Examples 1:

Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 
2nd row wil be set to 0.
 
Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. 
Therefore 1st row, 1st column and 4th column will be set to 0
 */
public class ZeroMatrix {
    public static void printMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void makeRowZero(int[][] matrix, int row) {
        int c = matrix[0].length;
        for (int i = 0; i < c; i++) {
            if (matrix[row][i] != 0)
                matrix[row][i] = -1;
        }
    }

    public static void makeColZero(int[][] matrix, int col) {
        int r = matrix.length;
        for (int i = 0; i < r; i++) {
            if (matrix[i][col] != 0)
                matrix[i][col] = -1;
        }
    }

    public static void brute(int matrix[][]) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    makeRowZero(matrix, i);
                    makeColZero(matrix, j);
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // better
    public static void better(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];

        // First pass to find all zeros
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Second pass to set rows and columns to zero
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Optimal approach
    public static void optimal(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int col0 = 1;

        // Step 1: Use first row and column as markers
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0)
                col0 = 0;
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Set zeroes based on markers (skip first row and col)
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Zero first row if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Zero first column if needed
        if (col0 == 0) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        /*
         * int[][] matrix = {
         * { 1, 1, 1 },
         * { 1, 0, 1 },
         * { 1, 1, 1 }
         * };
         */
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

        System.out.println("Before setting zeros:");
        printMatrix(matrix);

        optimal(matrix);

        System.out.println("After setting zeros:");
        printMatrix(matrix);
    }

}
