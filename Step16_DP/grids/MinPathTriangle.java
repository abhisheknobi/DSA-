package Step16_DP.grids;
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
    static void main(String[] args) {
        int [][]triangle={
                        {2},
                        {3,4},
                        {6,5,7},
                        {4,1,8,3}
                        };
        System.out.println(func(0,0,triangle));
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
}
