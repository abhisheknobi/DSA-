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
        return space(dp,grid);

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

    private static int tab(int[][]dp,int[][]grid){
        int m= grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)
                    dp[i][j]=grid[i][j];
                else{
                int up = grid[i][j];

                if (i > 0) up += dp[i - 1][j];
                else up += (int)1e9;

                // Calculate from left
                int left = grid[i][j];
                if (j > 0) left += dp[i][j - 1];
                else left += (int)1e9;

                // Take minimum
                dp[i][j] = Math.min(up, left);
            }
            }
        }
        return dp[m-1][n-1];
    }

    private static int space(int[][]dp,int[][]grid){
        int m= grid.length;
        int n=grid[0].length;

        int []prev=new int[n];
        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0)
                    temp[j]=grid[i][j];
                else {
                    // Take up direction if valid
                    int up = grid[i][j];
                    if (i > 0)
                        up += prev[j];
                    else
                        up += (int)1e9;

                    // Take left direction if valid
                    int left = grid[i][j];
                    if (j > 0)
                        left += temp[j - 1];
                    else
                        left += (int)1e9;

                    // Take minimum of both directions
                    temp[j] = Math.min(up, left);
                }
            }
            prev=temp;
        }
        return prev[n-1];

    }
}
