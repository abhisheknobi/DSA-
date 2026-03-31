package Step16_DP.subsequences;

import java.util.Arrays;

/*
Given an integer array nums, return true if you can partition the array into
two subsets such that the sum of the elements in both subsets is equal or false otherwise.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        System.out.println("Result for nums: " + func(nums));   // true
        System.out.println("Result for nums2: " + func(nums2)); // false
    }

    private static boolean func(int[] nums) {
        int totSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }

        if (totSum % 2 == 1) return false;

        // FIXED: Pass nums.length instead of nums.length - 1
        // FIXED: Pass totSum / 2 instead of totSum
        return space(nums.length, totSum / 2, nums);
    }

    private static boolean rec(int[] nums, int target, int index) {
        if (target == 0) return true;
        if (index == 0) return nums[0] == target;

        boolean taken = false;
        // FIXED: Check nums[index] instead of nums[0]
        if (nums[index] <= target) {
            taken = rec(nums, target - nums[index], index - 1);
        }

        boolean nottaken = rec(nums, target, index - 1);

        return nottaken || taken;
    }

    public static boolean memo(int n, int k, int[] arr) {
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memo_helper(n - 1, k, arr, dp);
    }

    private static boolean memo_helper(int ind, int target, int[] arr, int[][] dp) {
        if (dp[ind][target] != -1) return dp[ind][target] == 1;
        if (target == 0) return true;
        if (ind == 0) return target == arr[0];

        boolean notTaken = memo_helper(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target) {
            taken = memo_helper(ind - 1, target - arr[ind], arr, dp);
        }

        // FIXED: Proper bracing used above for clarity
        dp[ind][target] = (taken || notTaken) ? 1 : 0;

        return taken || notTaken;
    }

    public static boolean tab(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (arr[0] <= k) dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;
                // FIXED: Check arr[ind] <= target, NOT arr[ind] <= k
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = notTaken || taken;
            }
        }
        return dp[n - 1][k];
    }

    public static boolean space(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];

        prev[0] = true;

        if (arr[0] <= k) prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;

            // FIXED: Loop condition is target <= k, NOT target < n
            for (int target = 1; target <= k; target++) {
                boolean notTaken = prev[target];

                boolean taken = false;
                // FIXED: Check arr[ind] <= target, NOT arr[ind] <= k
                if (arr[ind] <= target) {
                    // FIXED: prev[target - arr[ind]], NOT prev[arr[ind] - target]
                    taken = prev[target - arr[ind]];
                }
                curr[target] = notTaken || taken;
            }
            prev = curr;
        }
        return prev[k];
    }

}
