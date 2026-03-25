package Step16_DP.grids;

import java.util.Arrays;

/*
Problem Statement: Given two integers m and n, representing the number of
rows and columns of a 2d array named matrix. Return the number of unique ways
to go from the top-left cell (matrix[0][0]) to the bottom-right cell (matrix[m-1][n-1]).

Movement is allowed only in two directions from a cell: right and bottom.

Examples
Example 1:
Input:
 m = 3, n = 2
Output:
 3
Explanation:
 There are 3 unique ways to go from the top-left to the bottom-right cell:
1) right → down → down
2) down → right → down
3) down → down → right

Example 2:
Input:
 m = 2, n = 4
Output:
 4
Explanation:
 There are 4 unique ways to go from the top-left to the bottom-right cell:
1) down → right → right → right
2) right → down → right → right
3) right → right → down → right
4) right → right → right → down
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.println("Memoization: " + uniqueMemo(m, n));
        System.out.println("Tabulation: " + uniqueTab(m, n));
        System.out.println("Optimized: " + optimized(m, n));
    }

    private static int uniqueMemo(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return memo(m - 1, n - 1, dp);
    }

    private static int uniqueTab(int m, int n) {
        int[][] dp = new int[m][n];
        return tab(m, n, dp);
    }

    //memoization
    private static int memo(int i, int j, int[][] dp) {
        if(i==0 && j==0)
            return 1;
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];

        int up=memo(i-1,j,dp);
        int left=memo(i,j-1,dp);

        return dp[i][j]=up+left;
    }
    //tabulation
    static int tab(int m, int n, int[][] dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    //space optimization
    public static int optimized(int m, int n) {
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}
