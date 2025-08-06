package Step3.Hard;

/*
 * Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

Examples

Example 1:
Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result: 5
Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!

Example 2:
Input Format: N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
Result: 8
Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, 
{6, -2, 2, -8, 1, 7, 4, -10}
Length of longest subarray = 8

Example 3:
Input Format: N = 3, array[] = {1, 0, -5}
Result: 1
Subarray : {0}
Length of longest subarray = 1

Example 4:
Input Format: N = 5, array[] = {1, 3, -5, 6, -2}
Result: 0
Subarray: There is no subarray that sums to zero
 */
import java.util.HashMap;
import java.util.Map;

public class LargestSubSum {
    public static int brute(int arr[]) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static int optimal(int arr[]) {
        int n = arr.length;
        int max = 0;
        int preSum = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1); // To handle the case when
        // subarray starts from index 0

        for (int i = 0; i < n; i++) {
            preSum += arr[i];

            if (mpp.containsKey(preSum)) {
                max = Math.max(max, i - mpp.get(preSum));
            } else {
                mpp.put(preSum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = { 9, -3, 3, -1, 6, -5 };
        int result = brute(array);
        System.out.println("Length of longest subarray with sum 0: " + result);
    }

}
