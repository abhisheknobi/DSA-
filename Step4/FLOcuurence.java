package Step4;

/*
 * Given a sorted array of N integers, write a program 
 * to find the index of the last occurrence of the target
 *  key. If the target is not found then return -1.

Note: Consider 0 based indexing

Examples:

Example 1:
Input: N = 7, target=13, array[] = {3,4,13,13,13,20,40}
Output: 4
Explanation: As the target value is 13 , it appears for the first time at index number 2.

Example 2:
Input: N = 7, target=60, array[] = {3,4,13,13,13,20,40}
Output: -1
Explanation: Target value 60 is not present in the array 
 */
public class FLOcuurence {
    public static int[] brute(int[] arr, int target) {
        int ans[] = new int[2];
        int first = -1, last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1)
                    first = i;
                last = i;
            }
        }
        ans[0] = first;
        ans[1] = last;
        return ans;
    }

    public static int upperBound(int[] arr, int x) {
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

    public static int[] better(int[] arr, int target) {
        if (lowerBound(arr, target) == -1) {
            return new int[] { -1, -1 }; // If target is not found
        }
        if (upperBound(arr, target) == -1) {
            return new int[] { -1, -1 }; // If target is not found
        }
        int first = lowerBound(arr, target);
        int last = upperBound(arr, target) - 1; // upperBound returns the index of the first element greater than target
        return new int[] { first, last };
    }

    public static int last(int[] v, int key) {
        int start = 0;
        int n = v.length;
        int end = n - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (v[mid] == key) {
                res = mid;
                start = mid + 1;

            } else if (key < v[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int first(int[] v, int key) {
        int start = 0;
        int n = v.length;
        int end = n - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (v[mid] == key) {
                res = mid;
                end = mid - 1;

            } else if (key < v[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int[] optimal(int[] arr, int target) {
        int first = first(arr, target);
        int last = last(arr, target);
        return new int[] { first, last };
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 13, 13, 13, 20, 40 };
        int[] arr2 = { 4, 6, 8, 8, 8, 11, 13 };
        int target = 13;
        int target2 = 8;
        int answer[] = brute(arr, target);
        System.out.println("First occurrence of " + target + " is at index: " + answer[0]);
        System.out.println("Last occurrence of " + target + " is at index: " + answer[1]);

        target = 60;
        int answer2[] = better(arr2, target2);
        System.out.println("First occurrence of " + target + " is at index: " + answer2[0]);
        System.out.println("Last occurrence of " + target + " is at index: " + answer2[1]);
    }
}
