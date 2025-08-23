package Step3_Arrays.Medium;

/*
 * Problem Statement: Given a matrix, your task is to rotate
 *  the matrix 90 degrees clockwise.

Note: Rotate matrix 90 degrees anticlockwise

Examples
Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]

Output: [[7,4,1],[8,5,2],[9,6,3]]

Explanation: Rotate the matrix simply by 90 degree clockwise
 and return the matrix.

Example 2:

Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Explanation: Rotate the matrix simply by 90 degree clockwise 
and return the matrix
 */
public class RotateClockWise {
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

    public static void brute(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int ans[][] = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[j][r - i - 1] = arr[i][j];
            }
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                arr[i][j] = ans[i][j];
            }
        }

    }

    public static void optimal(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Before rotation:");
        printMatrix(matrix);

        optimal(matrix);

        System.out.println("After rotation:");
        printMatrix(matrix);
    }
}
