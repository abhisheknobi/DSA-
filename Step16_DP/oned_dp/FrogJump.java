package Step16_DP.oned_dp;
/*
Problem Statement: Given a number of stairs and a frog, the frog wants to climb from the
 0th stair to the (N-1)th stair. At a time the frog can climb either one or two steps.
 A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, the
 energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute
  difference. We need to return the minimum energy that can be used by the frog to jump
  from stair 0 to stair N-1..

Examples
Example 1:
Input: heights = [2, 1, 3, 5, 4]
Output: 2
Explanation: One possible route can be,
0th step -> 2nd Step = abs(2 - 3) = 1
2nd step -> 4th step = abs(3 - 4) = 1
Total = 1 + 1 = 2.

Example 2:
Input: heights = [7, 5, 1, 2, 6]
Output: 9
Explanation: One possible route can be,
0th step -> 1st Step = abs(7 - 5) = 2
1st step -> 3rd step = abs(5 - 2) = 3
3rd step -> 4th step = abs(2 - 6) = 4
Total = 2 + 3 + 4 = 9.
 */
import java.util.Arrays;

public class FrogJump {
    // Solve function using recursion with memoization
    // ind -> current index the frog needs to reach
    // height -> array of heights
    // dp -> memo table where dp[i] stores min cost to reach i
    private static int solve(int ind, int[] height, int[] dp) {
        // If at the first stone, cost is 0
        if (ind == 0) return 0;

        // Return memoized result if already computed
        if (dp[ind] != -1) return dp[ind];

        // Initialize right with a large value because if the index is 1
        //then only left can be taken and right is discarded hence by making it max
        //right is discarded and value of left is taken
        int right = Integer.MAX_VALUE;

        // Compute cost when jumping from previous stone (ind - 1)
        int left = solve(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);

        // Compute cost when jumping from two stones back (ind - 2) if possible
        if (ind > 1) {
            right = solve(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
        }

        // Memoize and return the minimum of the two choices
        dp[ind] = Math.min(left, right);
        return dp[ind];
    }

    //tabulation it happens in bottoms up fashion

    public static int solve_tab(int []arr,int[]dp){
        dp[0]=0;
        for(int i=1;i<=arr.length-1;i++){
            int left=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            int right= Integer.MAX_VALUE;
            if(i>1){
                right=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(left,right);
        }
        return dp[arr.length-1];
    }

    //This uses O(N) as time complexity and O(1) as space complexity.
    public int frogJump_optimal(int[] height) {
        // Handle empty input
        if (height == null || height.length == 0) return 0;

        // Fetch number of stones
        int n = height.length;

        // Handle single stone case
        if (n == 1) return 0;

        // Initialize the cost to reach i-1 (prev) and i-2 (prev2)
        int prev = 0;
        int prev2 = 0;

        // Iterate through stones from index 1 to n-1
        for (int i = 1; i < n; i++) {
            // Initialize jumpTwo with large value
            int jumpTwo = Integer.MAX_VALUE;

            // Compute cost for jumping from i-1
            int jumpOne = prev + Math.abs(height[i] - height[i - 1]);

            // If possible, compute cost for jumping from i-2
            if (i > 1) {
                jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);
            }

            // Determine minimal cost to reach current stone
            int cur_i = Math.min(jumpOne, jumpTwo);

            // Shift window: update prev2 and prev
            prev2 = prev;
            prev = cur_i;
        }

        // Return minimal cost to reach last stone
        return prev;
    }

    // Helper to handle edge cases and start recursion
    public static int frogJump(int[] height) {
        // Handle empty input
        if (height == null || height.length == 0) return 0;

        // Prepare dp with -1 indicating uncomputed states
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Start from the last index
        return solve(n - 1, height, dp);
        //return solve_tab(height,dp);
    }
    static void main() {
        int[] arr={30, 10, 60, 10, 60, 50};
        System.out.println(frogJump(arr));

    }

}
