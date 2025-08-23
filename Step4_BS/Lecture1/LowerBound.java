package Step4_BS.Lecture1;

/*
 * Problem Statement: Given a sorted array of N integers and
 *  an integer x, write a program to find the lower bound of x.

Pre-requisite: Binary Search algorithm

Examples

Example 1:
Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
Result: 1
Explanation: Index 1 is the smallest index such that arr[1] >= x.

Example 2:
Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
Result: 3
Explanation: Index 3 is the smallest index such that arr[3] >= x.

 */
public class LowerBound {
    public static int lowerBound(int[] arr, int x) {
        int low = 0, n = arr.length, high = n - 1, mid = 0;
        int ans = -1;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] >= x) {
                ans = mid; // Update ans to the current mid
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
    /*
     * Problem Statement: Given a sorted array of N integers
     * and an integer x, write a program to find the upper bound of x.
     * 
     * Pre-requisite: Binary Search algorithm
     * 
     * Examples
     * 
     * Example 1:
     * Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
     * Result: 3
     * Explanation: Index 3 is the smallest index such that arr[3] > x.
     * 
     * Example 2:
     * Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
     * Result: 4
     * Explanation: Index 4 is the smallest index such that arr[4] > x.
     * 
     */

    public static int upperBound(int[] arr, int x) {
        int low = 0, n = arr.length, high = n - 1, mid = 0;
        int ans = -1;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] > x) {
                ans = mid; // Update ans to the current mid
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 9, 15, 19 };
        int x = 9;
        System.out.println("Lower Bound of " + x + " is at index: " + lowerBound(arr, x));
        System.out.println("Upper Bound of " + x + " is at index: " + upperBound(arr, x));

    }

}
