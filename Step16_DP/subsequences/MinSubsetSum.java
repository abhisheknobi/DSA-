package Step16_DP.subsequences;
/*
You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.

Return the minimum possible absolute difference.



Example 1:

example-1
Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
Example 2:


 */
import java.util.Arrays;
public class MinSubsetSum {
    public static void main(String[] args) {
        // Test array with negative numbers
        int[] arr = {3,9,7,3};

        System.out.println("--- Minimum Subset Sum Difference ---");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Result using Memoization: " + minimumDifference_memo(arr));
        System.out.println("Result using Tabulation:  " + minSubsetSumDifference_tab(arr,arr.length));
    }

    //positive numbers
    public static int minimumDifference_memo(int[] arr) {
        int n = arr.length;
        int totSum = 0;

        // 1. Calculate the total sum of the array
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // 2. Initialize DP table (int array for -1/0/1 states)
        // Since all numbers are positive, the target sums range from 0 to totSum
        int[][] dp = new int[n][totSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // 3. Populate DP table for all possible sums up to totSum
        for (int i = 0; i <= totSum; i++) {
            memoHelper(n - 1, i, arr, dp);
        }

        // 4. Find the minimum absolute difference
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totSum; i++) {
            // Check if the sum 'i' is possible by looking at the last row
            if (dp[n - 1][i] == 1) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    private static boolean memoHelper(int ind, int target, int[] arr, int[][] dp) {
        // Base case: If target is 0, it's always possible (empty subset)
        if (target == 0) {
            dp[ind][target] = 1;
            return true;
        }

        // Base case: First element
        if (ind == 0) {
            boolean isPossible = (target == arr[0]);
            dp[ind][target] = isPossible ? 1 : 0;
            return isPossible;
        }

        // Return if previously calculated
        if (dp[ind][target] != -1) {
            return dp[ind][target] == 1;
        }

        // Exclude current element
        boolean notTaken = memoHelper(ind - 1, target, arr, dp);

        // Include current element (only if the target is greater than or equal to the element)
        boolean taken = false;
        if (target >= arr[ind]) {
            taken = memoHelper(ind - 1, target - arr[ind], arr, dp);
        }

        // Store result and return
        dp[ind][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }

    public static int minSubsetSumDifference_tab(int[] arr, int n) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        // dp[i][j] will be true if a subset of first i elements has a sum equal to j
        boolean[][] dp = new boolean[n][totSum + 1];

        // Base case: A sum of 0 is always possible (empty subset)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case: First element can only form a subset equal to its own value
        if (arr[0] <= totSum) {
            dp[0][arr[0]] = true;
        }

        // Bottom-up DP table filling
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        // We only need to check up to totSum / 2 to find the minimum difference
        for (int s1 = 0; s1 <= totSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = totSum - s1;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }
        return mini;
    }
}
