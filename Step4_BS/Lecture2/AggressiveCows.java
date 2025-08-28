package Step4_BS.Lecture2;

/*
 * Problem Statement: You are given an array 'arr' of size 'n'
 *  which denotes the position of stalls.
You are also given an integer 'k' which denotes the number of 
aggressive cows.
You are given the task of assigning stalls to 'k' cows such that
 the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance.

Examples

Example 1:
Input Format: N = 6, k = 4, arr[] = {0,3,4,7,10,9}
Result: 3
Explanation: The maximum possible minimum distance between any
 two cows will be 3 when 4 cows are placed at positions {0, 3, 
 7, 10}. Here the distances between cows are 3, 4, and 3 respectively.
  We cannot make the minimum distance greater than 3 in any ways.

Example 2:
Input Format: N = 5, k = 2, arr[] = {4,2,1,3,6}
Result: 5
Explanation: The maximum possible minimum distance between any 
two cows will be 5 when 2 cows are placed at positions {1, 6}. 
 */
import java.util.Arrays;

public class AggressiveCows {
    public static boolean canWePlace(int arr[], int distance, int cows) {
        int lastPos = arr[0];// position of last placed cow
        int n = arr.length;
        int cowCount = 1;// number of cows placed
        for (int i = 1; i < n; i++) {
            if (arr[i] - lastPos >= distance) {
                cowCount++;
                lastPos = arr[i];
            }
            if (cowCount >= cows)
                return true;
        }
        return false;
    }

    public static int brute(int arr[], int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = arr[n - 1];
        int min = arr[0];
        int limit = max - min;
        for (int i = 1; i <= limit; i++) {
            if (canWePlace(arr, i, k) == false)
                return i - 1;

        }
        return limit;

    }

    public static int optimal(int arr[], int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 1, high = arr[n - 1] - arr[0], mid = 0;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (canWePlace(arr, mid, k) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 3, 4, 7, 10, 9 };
        int k = 4;
        System.out.println(brute(arr, k));
        int arr2[] = { 4, 2, 1, 3, 6 };
        int k2 = 2;
        System.out.println(optimal(arr2, k2));

    }

}
