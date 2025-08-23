package Step3_Arrays.Hard;

/*
 * Problem Statement: You are given a read-only array of N
 *  integers with values also in the range [1, N] both inclusive. 
 * Each integer appears exactly once except A which appears twice
 *  and B which is missing. The task is to find the repeating and
 *  missing numbers A and B where A repeats twice and B is missing.

Examples

Example 1:
Input Format:  array[] = {3,1,2,5,3}
Result: {3,4)
Explanation: A = 3 , B = 4 
Since 3 is appearing twice and 4 is missing

Example 2:
Input Format: array[] = {3,1,2,5,4,6,7,5}
Result: {5,8)
Explanation: A = 5 , B = 8 
Since 5 is appearing twice and 8 is missing
 */
public class MissRepeat {

    public static int[] brute(int[] a) {
        int n = a.length;
        int[] res = new int[2];
        int repeating = -1, missing = -1;

        // Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            // Count the occurrences:
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] == i)
                    cnt++;
            }

            if (cnt == 2)
                repeating = i;
            else if (cnt == 0)
                missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = { repeating, missing };
        return ans;
    }

    public static int[] better(int[] arr) {
        int n = arr.length;
        int[] hashh = new int[n + 1];
        for (int i = 1; i < n; i++) {
            hashh[arr[i]]++;
        }
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hashh[i] == 2)
                repeating = i;
            else if (hashh[i] == 0)
                missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = { repeating, missing };
        return ans;

    }

    public static int[] optimal1(int[] a) {
        long n = a.length; // size of the array
        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;// sum of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6; // sum of squares of n number

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long) a[i] * (long) a[i];
        }

        // S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2-> X^2-Y^2 = (X+Y)(X-Y):
        long val2 = S2 - S2N;

        // Find X+Y = (X^2-Y^2)/(X-Y)-> val2=x+y
        val2 = val2 / val1;

        // Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = { (int) x, (int) y };
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 3 };
        int[] result = optimal1(arr);
        System.out.println("Missing: " + result[0] + ", Repeating: " + result[1]);
    }

}
