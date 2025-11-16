package Step4_BS.Lecture2;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Statement:
Given two sorted arrays arr1 and arr2 of size m and n 
respectively, return the median of the two sorted arrays.
 The median is defined as the middle value of a sorted
  list of numbers. In case the length of the list is even,
   the median is the average of the two middle elements.

Examples
Input: n1 = 3, arr1[] = {2,4,6}, n2 = 3, arr2[] = {1,3,5}
Output: 3.5
Explanation: 
The array after merging 'a' and 'b' will be {1, 2, 3, 4, 5, 6}.
 As the length of the merged list is even, the median is the 
 average of the two middle elements. Here two medians are 3 
 and 4. So the median will be the average of 3 and 4, which 
 is 3.5.

Input: n1 = 3, arr1[] = {2,4,6}, n2 = 2, arr2[] = {1,3}
Output: 3
Explanation: 
The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 6 }
. The median is 3.
 */
public class MedianOfSortedArray {
    public static double brute(int[] nums1, int[] nums2) {
        
        // Create a list to store merged sorted elements
        List<Integer> merged = new ArrayList<>();
        
        // Initialize two pointers to traverse both arrays
        int i = 0, j = 0;

        // Merge both arrays into the merged list in sorted order
        while (i < nums1.length && j < nums2.length) {
            // If element in nums1 is smaller, add to merged
            if (nums1[i] < nums2[j])
                merged.add(nums1[i++]);
            else
                merged.add(nums2[j++]);
        }

        // Add any remaining elements from nums1
        while (i < nums1.length)
            merged.add(nums1[i++]);

        // Add any remaining elements from nums2
        while (j < nums2.length)
            merged.add(nums2[j++]);

        // Find the size of the merged array
        int n = merged.size();

        // If size is odd, return the middle element
        if (n % 2 == 1)
            return merged.get(n / 2);

        // If size is even, return the average of the two middle elements
        return (merged.get(n / 2 - 1) + merged.get(n / 2)) / 2.0;
    }


    public static double better(int[] a, int[] b) {

        // Get sizes of both arrays
        int n1 = a.length, n2 = b.length;

        // Total size
        int n = n1 + n2;

        // Median indices
        int ind2 = n / 2;
        int ind1 = ind2 - 1;

        // Initialize pointers and values
        int cnt = 0, i = 0, j = 0;
        int ind1el = -1, ind2el = -1;

        // Merge step to find median
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                i++;
            } else {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                j++;
            }
            cnt++;
        }

        // Remaining elements in a
        while (i < n1) {
            if (cnt == ind1) ind1el = a[i];
            if (cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }

        // Remaining elements in b
        while (j < n2) {
            if (cnt == ind1) ind1el = b[j];
            if (cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }

        // Return median
        if (n % 2 == 1) return (double) ind2el;
        return (ind1el + ind2el) / 2.0;
    }



public double optimal(int[] a, int[] b) {
        // Make sure array a is the smaller one to minimize binary search range
        if (a.length > b.length) return findMedianSortedArrays(b, a);

        int n1 = a.length, n2 = b.length;
        int low = 0, high = n1;

        // Binary search on the smaller array
        while (low <= high) {
            // Calculate cut points for both arrays
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            // Get values to the left and right of the partition
            // Use Integer.MIN_VALUE and MAX_VALUE to handle edge cases
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];

            // If partition is valid
            if (l1 <= r2 && l2 <= r1) {
                // Even total elements => average of two middle elements
                if ((n1 + n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    // Odd total elements => max of left parts
                    return Math.max(l1, l2);
            }
            // Move left in array a
            else if (l1 > r2)
                high = cut1 - 1;
            // Move right in array a
            else
                low = cut1 + 1;
        }

        return 0.0; 
    }



    public static void main(String[] args) {
        
        // Create object of Solution class

        // Define two input sorted arrays
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        // Call function to get median
        double median = brute(nums1, nums2);

        // Print the median result
        System.out.println(median);
    }
