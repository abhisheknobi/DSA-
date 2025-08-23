package Step4_BS.Lecture2;

/*
 * Problem Statement: Given two numbers N and M, find the Nth root of
 *  M. The nth root of a number M is defined as a number X when raised 
 * to the power N equals M. If the 'nth root is not an integer, return -1.

Examples

Example 1:
Input Format: N = 3, M = 27
Result: 3
Explanation: The cube root of 27 is equal to 3.

Example 2:
Input Format: N = 4, M = 69
Result: -1
Explanation: The 4th root of 69 does not exist. So, the answer is -1.
 */
public class NthRoot {
    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m)
                return 2;
        }
        if (ans == m)
            return 1;
        return 0;
    }

    public static int optimal(int n, int m) {
        // Use binary search on the answer space:
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) {
                return mid;
            } else if (midN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3; // Nth root
        int m = 27; // M value
        int ans = optimal(n, m);
        System.out.println("The " + n + "th root of " + m + " is: " + ans);
    }

}
