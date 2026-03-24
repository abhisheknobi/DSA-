package Step16_DP.oned_dp;


/*
You are a professional robber planning to rob houses
along a street. Each house has a certain amount of money stashed.
 All houses at this place are arranged in a circle. That means the
  first house is the neighbor of the last one. Meanwhile, adjacent
  houses have a security system connected, and it will automatically
  contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each
 house, return the maximum amount of money you can rob tonight without
 alerting the police.



Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {
    public static int solve_space(int[] nums) {
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
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Create two sub-arrays to handle the circular constraint
        int[] arr1 = new int[n - 1]; // Excludes the first house
        int[] arr2 = new int[n - 1]; // Excludes the last house

        for (int i = 0; i < n; i++) {
            if (i != 0) arr1[i - 1] = nums[i];
            if (i != n - 1) arr2[i] = nums[i];
        }

        return Math.max(solve_space(arr1), solve_space(arr2));
    }

    static void main() {
        int []nums={2,3,2};
        System.out.println(rob(nums));
    }
}
