package Step7_Recursion.Lec_1;
/*
 * Problem Statement: A digit string is considered good if the
 *  digits at even indices (0-based) are even digits 
 * (0, 2, 4, 6, 8) and the digits at odd indices are 
 * prime digits (2, 3, 5, 7).

Given an integer n, return the total number of good digit strings 
of length n. As the result may be large, return it modulo 109 + 7.

A digit string is a string consisting only of the digits '0' 
through '9'. It may contain leading zeros.

Examples
Example 1:
Input: n = 1
Output: 5
Explanation: Only one index (0) → must be even.
Valid strings: "0", "2", "4", "6", "8"

Example 2:
Input: n = 2
Output: 20
Explanation: Index 0: 5 options (even digits)
Index 1: 4 options (prime digits)
Total: 5 * 4 = 20
 */
public class GoodNumber {
    static final int MOD = 1_000_000_007;

public long power(long x, long y) {
    if (y == 0) return 1;
    long ans = power(x, y/2);     // Recurse on half
    ans = (ans * ans) % MOD;      // Square it
    if (y % 2 == 1)
        ans = (ans * x) % MOD;    // If odd, multiply by x once
    return ans;
}
    public int countGoodNumbers(long n) {
       long odd=n/2;
       long even=(n/2) + (n%2);
       return (int) ((power(5,even))*(power(4,odd))%MOD);
    }
    
    public static void main(String[] args) {
        GoodNumber obj=new GoodNumber();
        System.out.println(obj.countGoodNumbers(50));
    }
}
