package Step16_DP.grids;

import java.util.Arrays;

/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below.
 More formally, if you are on index i on the current row, you may move
  to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 */
public class MinPathTriangle {
    public static void main(String[] args) { // Corrected main method signature
        int [][]triangle={
                        {2},
                        {3,4},
                        {6,5,7},
                        {4,1,8,3}
                        };
        // Correctly initialize dp array for a triangle
        int[][]dp=new int[triangle.length][];
        for (int k = 0; k < triangle.length; k++) {
            dp[k] = new int[triangle[k].length];
            Arrays.fill(dp[k], -1);
        }
        System.out.println(memo(0,0,triangle,dp));
    }
    //recursive
    /*
    here we changed our model that is previously we started from
    n-1 going down to the base case but here we do the opp
    because if we start from n-1 then we need to take 4 different
    recursion routes for the jth index
     */
    private static int func(int i, int j,int[][]arr) {
        if(i== arr.length-1)
            return arr[i][j];
        int d=func(i+1,j,arr)+arr[i][j];
        int dg=func(i+1,j+1,arr)+arr[i][j];
        return Math.min(d,dg);
    }

    //memoization
    private static int memo(int i,int j,int[][]arr,int[][]dp){
        // Base case: If we are at the last row, return the value at that position
        if(i == arr.length - 1) {
            return arr[i][j];
        }

        // If the value is already computed, return it
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        // Recursive calls for down and down-right paths
        // d: move to (i+1, j)
        int d = arr[i][j] + memo(i + 1, j, arr, dp);
        // dg: move to (i+1, j+1)
        int dg = arr[i][j] + memo(i + 1, j + 1, arr, dp);

        // Store the minimum of the two paths in dp and return it
        return dp[i][j] = Math.min(d, dg);
    }
}
