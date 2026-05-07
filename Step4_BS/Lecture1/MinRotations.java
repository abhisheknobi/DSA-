package Step4_BS.Lecture1;
/*
Problem Statement: Given an integer array arr of size N, 
sorted in ascending order (with distinct values). Now the 
array is rotated between 1 to N times which is unknown. 
Find how many times the array has been rotated. 

Pre-requisites: Find minimum in Rotated Sorted Array,  
Search in Rotated Sorted Array II & Binary Search algorithm

Examples

Example 1:
Input Format: arr = [4,5,6,7,0,1,2,3]
Result: 4
Explanation: The original array should be [0,1,2,3,4,5,6,7]. 
So, we can notice that the array has been rotated 4 times.

Example 2:
Input Format: arr = [3,4,5,1,2]
Result: 3
Explanation: The original array should be [1,2,3,4,5]. 
So, we can notice that the array has been rotated 3 times.

 */

public class MinRotations {
    public static int brute(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }

        }
        return index;
    }

    public static int optimal(int[] arr) {
        int low = 0, high = arr.length - 1;

        // If the array is not rotated at all
        if (arr[low] <= arr[high]) return 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the minimum element
            // 1. If mid > mid + 1, then mid + 1 is the minimum
            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            // 2. If mid < mid - 1, then mid is the minimum
            if (mid > low && arr[mid] < arr[mid - 1]) {
                return mid;
            }

            // Decide which half to search:
            // If left half is sorted, the pivot is in the right half
            if (arr[mid] >= arr[low]) {
                low = mid + 1;
            }
            // If left half is unsorted, the pivot is in the left half
            else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println("Array has been rotated " + optimal(arr) + " times.");
        int[] arr2 = { 3, 4, 5, 1, 2 };
        System.out.println("Array has been rotated " + optimal(arr2) + " times.");
    }
}
