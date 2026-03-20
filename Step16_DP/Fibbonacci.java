package Step16_DP;

import java.util.Arrays;

public class Fibbonacci {
    /*
    Memoization method
    Here time complexity:O(n) linear time working
    Space Complexity: O(N)+O(N) One is for recursion stack space and
    other for storing dp array
     */
    public static int fib_memo(int n, int[] dp) {
        // If base case return n
        if (n <= 1) return n;

        // If already computed, return stored value
        if (dp[n] != -1) return dp[n];

        // Otherwise compute and store
        dp[n] = fib_memo(n - 1, dp) + fib_memo(n - 2, dp);
        return dp[n];
    }

    /*
    Tabulation Method
    Here time complexity:O(n) linear time working
    Space Complexity: O(N)
    ONLY for storing dp array
     */
    public int fib_tab(int n) {
        // If n is 0 or 1, return n
        if (n <= 1) return n;

        // Create dp array
        int[] dp = new int[n + 1];

        // Initialize base cases
        dp[0] = 0;
        dp[1] = 1;

        // Fill dp array iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return final answer
        return dp[n];
    }

    static int fib(int n) {
        // If n is 0 return 0
        if(n == 0) return 0;
        // If n is 1 return 1
        if(n == 1) return 1;

        // prev2 stores fib(n-2)
        int prev2 = 0;
        // prev stores fib(n-1)
        int prev = 1;
        // curr stores current fib
        int curr = 0;

        // Loop from 2 to n
        for(int i = 2; i <= n; i++) {
            // Calculate current fib
            curr = prev + prev2;
            // Update prev2
            prev2 = prev;
            // Update prev
            prev = curr;
        }
        // Return final answer
        return prev;
    }

    static void main() {
        int n = 10;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fib_memo(n,dp));
        System.out.println(fib(10));
    }
}
