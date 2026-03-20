package Step16_DP;

import java.util.Arrays;

/*
Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair.
 At a time we can climb either one or two steps. We need to return the total number of distinct ways to reach
  from 0th to Nth stair.

Examples
Input: n = 2
Output: 2
Explanation: There are 2 unique ways to climb to the 2nd step:
1. 1 step + 1 step
2. 2 steps

Input: n = 3
Output: 3
Explanation: There are 3 unique ways to climb to the 3rd step:
1. 1 step + 1 step + 1 step
2. 2 steps + 1 step
3. 1 step + 2 steps
 */
public class ClimbingStairs {
    static int func(int indx){
        if(indx<=1){
            return 1;
        }
        return func(indx-1)+func(indx-2);

    }
    static int func_dp(int indx) {
        int[] dp = new int[indx + 1];
        Arrays.fill(dp, -1);

        if(dp[indx]!=-1)
            return dp[indx];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= indx; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[indx];
    }
    static void main() {
        int n=4;
        System.out.println(func_dp(n));

    }
}
