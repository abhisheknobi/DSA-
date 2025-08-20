package Step4;
/*
 * Problem Statement: You are given a sorted array arr of distinct 
 * values and a target value x. You need to search for the index of
 *  the target value in the array.

If the value is present in the array, then return its index. Otherwise,
 determine the index where it would be inserted in the array while maintaining 
 the sorted order.

Pre-requisite: Lower Bound & Binary Search

Example 1:
Input Format: arr[] = {1,2,4,7}, x = 6

Result: 3
Explanation: 6 is not present in the array. So, if we will insert 6 in the
 3rd index(0-based indexing), the array will still be sorted. {1,2,4,6,7}.

Example 2:
Input Format: arr[] = {1,2,4,7}, x = 2
Result: 1
Explanation: 2 is present in the array and so we will return its index i.e. 1.
 */

public class SearchInsert {

    public static int optimal(int[] arr, int x) {
        int low = 0, n = arr.length, high = n - 1, mid = 0;
        int ans = n; // Default to the end of the array
        while (low <= high) {
            mid = low + ((high - low) / 2);
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7 };
        int x = 6;
        System.out.println(optimal(arr, x));
        x = 2;
        System.out.println(optimal(arr, x));

    }
}
