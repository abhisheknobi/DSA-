package Step16_DP;

import java.util.Arrays;

/*
Problem Statement:

A frog wants to climb a staircase with n steps. Given an integer array heights,
 where heights[i] contains the heights of the ith step, and an integer k. To jump
 from the ith step to the jth step, the frog requires abs(heights[i] - heights[j])
  energy, where abs() denotes the absolute difference. The frog can jump from the ith
   step to any step in the range [i + 1, i + k], provided it exists. Return the minimum
    amount of energy required by the frog to go from the 0th step to the (n-1)th step.

Examples
Example 1:
Input: heights = [10, 5, 20, 0, 15], k = 2
Output: 15
Explanation:
0th step -> 2nd step, cost = abs(10 - 20) = 10
2nd step -> 4th step, cost = abs(20 - 15) = 5
Total cost = 10 + 5 = 15.

Example 2:
Input: heights = [15, 4, 1, 14, 15], k = 3
Output: 2
Explanation:
0th step -> 3rd step, cost = abs(15 - 14) = 1
3rd step -> 4th step, cost = abs(14 - 15) = 1
Total cost = 1 + 1 = 2.
 */
public class KFrogJump {
    public static int frogJump(int[] heights, int k) {
        // Handle empty input
        if (heights == null || heights.length == 0) return 0;

        // Prepare dp with -1 indicating uncomputed states
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Start from the last index
        return memo(n - 1, heights,k,dp);
    }
    static void main() {
        int[] heights={15, 4, 1, 14, 15};
        int k=3;
        int[] heights1= {10, 5, 20, 0, 15};
        int k1=2;
        System.out.println(frogJump(heights1,k1));
    }

    //logic building
    private static int recursive(int i,int[] heights, int k) {
        if(i==0)
            return 0;
        int step;
        int minStep=Integer.MAX_VALUE;
       for(int j=1;j<=k;j++) {
           if (i >= j) {
               step = recursive(i - j, heights, k) + Math.abs(heights[i] - heights[i - j]);
               minStep=Math.min(minStep,step);
           }
       }
       return minStep;
    }

    //dp memoization
    private static int memo(int i,int[] heights, int k,int []dp){
        if(i==0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];

        int step;
        int minStep=Integer.MAX_VALUE;
        for (int j=1;j<=k;j++){
            if (i -j>=0) {
                step=memo(i-j,heights,k,dp)+Math.abs(heights[i]-heights[i-j]);
                minStep=Math.min(minStep,step);
        }
        }
            dp[i]=minStep;
        return dp[i];
        }

        //tabulation
    private static int tab(int[]heights,int k,int[] dp){
        dp[0] = 0;
        int n=heights.length;

        // Iterate over each stone
        for (int i = 1; i < n; i++) {
            // Initialize minimum cost for this stone as large value
            int mmSteps = Integer.MAX_VALUE;

            // Try all possible jump lengths from 1 to k
            for (int j = 1; j <= k; j++) {
                // Ensure jump doesn't go out of bounds
                if (i - j >= 0) {
                    // Cost of jumping from (i - j) to i
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i-j]);
                    // Keep track of the minimum cost
                    mmSteps = Math.min(mmSteps, jump);
                }
            }

            // Store computed minimum cost
            dp[i] = mmSteps;
        }

        // Last element of dp stores the answer
        return dp[n - 1];

    }

}
