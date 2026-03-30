package Step16_DP.subsequences;

import java.util.Arrays;

/*
Problem Statement: We are given an array ‘ARR’ with N positive integers.
We need to find if there is a subset in “ARR” with a sum equal to K. If
there is, return true else return false.

A subset/subsequence is a contiguous or non-contiguous part of an array,
where elements appear in the same order as the original array.
For example, for the array: [2,3,1] , the subsequences will be [{2},{3},
{1},{2,3},{2,1},{3,1},{2,3,1}} but {3,2} is not a subsequence because its
 elements are not in the same order as the original array.

Examples

Input :  N = 4, ARR = [4, 3, 5, 2], K = 6
Output : true
Explanation : One possible subset with sum = 6 is [4, 2]. There’s also
 [3, 3] but that doesn’t exist in the array. As soon as we find one subset
  whose sum is equal to K, the answer is true.

Input : N = 3, ARR = [1, 2, 5], K = 4
Output : false
Explanation : Possible subsets and their sums: [1] → 1, [2] → 2, [5] → 5,
 [1,2] → 3, [1,5] → 6, [2,5] → 7, [1,2,5] → 8. None of them equal 4, so the answer is false.
 */
public class SubsetSum {
    public boolean memo(int n, int k, int[] arr) {
        // Initialize memo table with -1 (unvisited)
        int[][] memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays  .fill(row, -1);
        }

        return solve(n - 1, k, arr, memo);
    }

    private boolean solve(int ind, int target, int[] arr, int[][] memo) {
        // Base case: target becomes 0, subset found
        if (target == 0) return true;

        // Base case: only one element left
        if (ind == 0) return arr[0] == target;

        // Return cached result if already computed
        if (memo[ind][target] != -1) return memo[ind][target] == 1;

        // Don't take current element
        boolean notTaken = solve(ind - 1, target, arr, memo);

        // Take current element (only if it doesn't exceed target)
        boolean taken = false;
        if (arr[ind] <= target) {
            taken = solve(ind - 1, target - arr[ind], arr, memo);
        }

        // Cache and return the result
        memo[ind][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }
    public static boolean tab(int n, int k, int[] arr) {
        // Initialize a 2D DP array with dimensions (n x k+1) to store subproblem results
        boolean[][] dp = new boolean[n][k + 1];

        // Base case: If the target sum is 0, we can always achieve it by taking no elements
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case: If the first element of 'arr' is <= k, set dp[0][arr[0]] to true
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill the DP array iteratively
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // If we don't take the current element, result is same as previous row
                boolean notTaken = dp[ind - 1][target];

                // If we take the current element, subtract its value from target and check previous row
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Store the result in the DP array for the current subproblem
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in dp[n-1][k]
        return dp[n - 1][k];
    }
    public static boolean space(int n, int k, int[] arr) {
        // 'prev' represents the results from the previous element (row)
        boolean[] prev = new boolean[k + 1];

        // Base case: A sum of 0 can always be achieved with an empty subset
        prev[0] = true;

        // Base case: If the first element is <= target k, mark that sum as possible
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        // Iterate through the remaining elements
        for (int ind = 1; ind < n; ind++) {
            // 'cur' represents the current row being calculated
            boolean[] cur = new boolean[k + 1];
            cur[0] = true; // Target 0 is always possible

            for (int target = 1; target <= k; target++) {
                // Option 1: Do not include the current element
                boolean notTaken = prev[target];

                // Option 2: Include the current element (if its value <= target)
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                // If either option works, the target is achievable
                cur[target] = notTaken || taken;
            }

            // Update prev to be the current row for the next iteration
            prev = cur;
        }

        // The answer for the full array and target k is in prev[k]
        return prev[k];
    }

    static void main() {
        int[] arr = {1, 2, 3, 4};
        int k = 4;
        int n = arr.length;
        if (space(n, k, arr)) {
            System.out.println("Subset with the given target found");
        } else {
            System.out.println("Subset with the given target not found");
        }

    }
}
