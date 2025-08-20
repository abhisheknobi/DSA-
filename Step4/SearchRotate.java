package Step4;

/*
 * Search Element in a Rotated Sorted Array

Mark as Completed

359


Problem Statement: Given an integer array arr of size N, 
sorted in ascending order (with distinct values) and a 
target value k. Now the array is rotated at some pivot 
point unknown to you. Find the index at which k is present
 and if k is not present return -1.

Examples

Example 1:
Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
Result: 4
Explanation: Here, the target is 0. We can see that 0 is 
present in the given rotated sorted array, nums. Thus,
 we get output as 4, which is the index at which 0 is 
 present in the array.

Example 2:
Input Format: arr = [4,5,6,7,0,1,2], k = 3
Result: -1
Explanation: Here, the target is 3. Since 3 is not present 
in the given rotated sorted array. Thus, we get the output as -1.
 */
public class SearchRotate {
    public static int optimal(int[] arr, int target) {
        int low = 0, n = arr.length, high = n - 1, mid = 0;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] == target)
                return mid; // found target
            if (arr[mid] <= arr[high]) {// right half is sorted

                // check if target is in between the sorted half
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1; // search in right half

                else
                    high = mid - 1;
            } else {// left half is sorted
                    // check if target is in between the sorted half
                if (arr[low] <= target && target <= arr[mid])
                    high = mid - 1; // search in left half
                else
                    low = mid + 1; // search in right half
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int k = 0;
        System.out.println("Index of " + k + " is: " + optimal(arr, k));

        int[] arr2 = { 4, 5, 6, 7, 0, 1, 2 };
        int k2 = 3;
        System.out.println("Index of " + k2 + " is: " + optimal(arr2, k2));
    }

}
