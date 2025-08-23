package Step4_BS.Lecture1;

/*
 * Problem Statement: Given a sorted array of N integers 
 * and an integer x, write a program to find the upper bound of x.

Pre-requisite: Binary Search algorithm

Examples

Example 1:
Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
Result: 3
Explanation: Index 3 is the smallest index such that arr[3] > x.

Example 2:
Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
Result: 4
Explanation: Index 4 is the smallest index such that arr[4] > x.
 */
public class UpperBound {
    public static int optimal(int[] arr, int x) {
        int low = 0, n = arr.length, high = n - 1, mid = 0;
        int ans = -1;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int x = 2;
        System.out.println("Upper Bound of " + x + " is at index: " + optimal(arr, x));

        int[] arr2 = { 3, 5, 8, 9, 15, 19 };
        int y = 9;
        System.out.println("Upper Bound of " + y + " is at index: " + optimal(arr2, y));
    }

}
