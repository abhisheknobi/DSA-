package Step3.Medium;

/*\
 * Problem Statement: Given an array of integers and an integer 
 * k, return the total number of subarrays whose sum equals k.

A subarray is a contiguous non-empty sequence of elements within 
an array.

Pre-requisite: Longest subarray with given sum

Examples

Example 1:
Input Format: N = 4, array[] = {3, 1, 2, 4}, k = 6
Result: 2
Explanation: The subarrays that sum up to 6 are [3, 1, 2] and 
[2, 4].

Example 2:
Input Format: N = 3, array[] = {1,2,3}, k = 3
Result: 2
Explanation: The subarrays that sum up to 3 are [1, 2], and [3].
 */
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static int brute(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int optimal(int[] arr, int k) {
        int n = arr.length; // size of the given array.
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;

    }

    public static void main(String[] args) {
        int[] array = { 3, 1, 2, 4 };
        int k = 6;
        int[] array2 = { 1, 2, 3 };
        int k2 = 3;
        System.out.println(brute(array2, k2));
    }

}
