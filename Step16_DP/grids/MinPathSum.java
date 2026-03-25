package Step16_DP.grids;

import java.util.Arrays;

/*
Problem Statement: Given a m x n grid filled with non-negative numbers,
 find a path from top left to bottom right, which minimizes the sum of
  all numbers along its path.
Note: You can only move either down or right at any point in time.

Examples
Input: grid = [[5,9,6],[11,5,2]]
Output: 21
Explanation: Minimum sum is achieved via path 5->9->5->2 i.e. 21.

Input : grid = [[1,2,3],[4,5,6]]
Output: 12
Explanation : Minimum sum is achieved via path 1->2->3->6 i.e. 12.
 */
public class MinPathSum {
    static void main(String[] args) {
        int [][]grid={{5,9,6},
                      {11,5,2}};
        int m= grid.length;
        int n=grid[0].length;
        System.out.println(func(m,n,grid));

    }

    private static int func(int m,int n,int [][]grid) {
        int [][]dp=new int[m][n];
        for(int []row:dp)
            Arrays.fill(row,-1);
        return memo(m-1,n-1,dp,grid);

    }
    //memoization
    private static int memo(int i, int j, int[][] dp, int[][] grid) {
        dp[0][0]=grid[0][0];
        if(i==0 && j==0)
            return dp[0][0];
        if(i<0 || j<0)
            return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;
        if(i>0)
            up=memo(i-1,j,dp,grid)+grid[i][j];
        if(j>0)
            left=memo(i,j-1,dp,grid)+grid[i][j];

        return dp[i][j]=Math.min(up,left);
    }
}
