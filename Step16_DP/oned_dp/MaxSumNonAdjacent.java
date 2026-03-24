package Step16_DP.oned_dp;

import java.util.Arrays;

/*
Problem Statement: Given an array of N positive integers, we need to return
the maximum sum of the subsequence such that no two elements of the subsequence
 are adjacent elements in the array.

Note: A subsequence of an array is a list with elements of the array where some
elements are deleted (or not deleted at all) and the elements should be in the
same order in the subsequence as in the array.

Examples
Input: nums = [1, 2, 4]
Output: 5
Explanation:
Subsequence {1,4} gives maximum sum.

Input:  [2, 1, 4, 9]
Output: 11
Explanation:
Subsequence {2,9} gives maximum sum
 */
public class MaxSumNonAdjacent {
    //memoization
    public static int solve(int[] arr, int i, int[] dp) {
        // No element to pick
        if (i < 0) return 0;

        // Only one element
        if (i == 0) return arr[0];

        // Return memoized result
        if (dp[i] != -1) return dp[i];

        // Pick current and move 2 back
        int pick = arr[i] + solve(arr, i - 2, dp);

        // Don't pick current, move 1 back
        int notPick = solve(arr, i - 1, dp);

        // Memoize and return result
        return dp[i] = Math.max(pick, notPick);
    }

    //tabulation
    private static int solve_tab(int[] arr,int i,int []dp){
        int n=arr.length;
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        if(n==1) return arr[0];

        for(int j=2;j<arr.length;j++){
            dp[i]=Math.max(arr[i]+dp[i-2],dp[i-1]);

        }
        return dp[n-1];
    }

    //space optimization
        public int solve_space(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0; // Handle empty array
            if (n == 1) return nums[0]; // Handle single house

            int prev = nums[0]; // Max money if we only had the 1st house
            int prev2 = 0;      // Max money if we had 0 houses

            for (int j = 1; j < n; j++) {
                // Option 1: Take current house + max from 2 houses ago
                int take = nums[j] + prev2;

                // Option 2: Skip current house, keep max from 1 house ago
                int notTake = prev;

                int curri = Math.max(take, notTake);

                // Update pointers for the next iteration
                prev2 = prev;
                prev = curri;
            }

            return prev;
        }

    // Main function to compute result
    public static int maximumNonAdjacentSum(int[] arr) {
        int n = arr.length;

        // Initialize DP array
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Start recursion
        return solve(arr, n - 1, dp);
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};

        // Print result
        System.out.println(maximumNonAdjacentSum(arr));
    }
}
