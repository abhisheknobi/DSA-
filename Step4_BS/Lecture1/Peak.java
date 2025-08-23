package Step4_BS.Lecture1;
/*
 * Problem Statement: Given an array of length N. Peak element 
 * is defined as the element greater than both of its neighbors.
 *  Formally, if 'arr[i]' is the peak element, 'arr[i - 1]' < 
 * 'arr[i]' and 'arr[i + 1]' < 'arr[i]'. Find the index(0-based)
 *  of a peak element in the array. If there are multiple peak 
 * numbers, return the index of any peak number.

Note: For the first element, the previous element should be 
considered as negative infinity as well as for the last element,
 the next element should be considered as negative infinity.

Pre-requisite: Binary Search Algorithm

Examples

Example 1:
Input Format: arr[] = {1,2,3,4,5,6,7,8,5,1}
Result: 7
Explanation: In this example, there is only 1 peak that is at
 index 7.

Example 2:
Input Format: arr[] = {1,2,1,3,5,6,4}
Result: 1
Explanation: In this example, there are 2 peak numbers that are 
at indices 1 and 5. We can consider any of them.

Example 3:
Input Format: arr[] = {1, 2, 3, 4, 5}
Result: 4
Explanation: In this example, there is only 1 peak that is at the
 index 4.

Example 4:
Input Format: arr[] = {5, 4, 3, 2, 1}
Result: 0
Explanation: In this example, there is only 1 peak that is at the
 index 0.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Peak {
    public static int optimal(List<Integer> arr) {
        int n = arr.size(); // Size of array

        // Edge cases:
        if (n == 1)
            return 0;
        if (arr.get(0) > arr.get(1))
            return 0;
        if (arr.get(n - 1) > arr.get(n - 2))
            return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the peak:
            if (arr.get(mid - 1) < arr.get(mid) && arr.get(mid) > arr.get(mid + 1))
                return mid;

            // If we are in the left:
            if (arr.get(mid) > arr.get(mid - 1))
                low = mid + 1;

            // If we are in the right:
            // Or, arr[mid] is a common point:
            else
                high = mid - 1;
        }
        // Dummy return statement
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 5, 1));
        System.out.println("Peak element index: " + optimal(arr1));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 5, 6, 4));
        System.out.println("Peak element index: " + optimal(arr2));

        List<Integer> arr3 = new ArrayList<>(Arrays.asList(1, 7, 5, 8, 10, 11));
        System.out.println("Peak element index: " + optimal(arr3));
    }

}
