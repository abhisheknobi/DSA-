package Step3_Arrays.Hard;

/*
 * Problem statement: Given two sorted arrays arr1[] and arr2[]
 *  of sizes n and m in non-decreasing order. Merge them in 
 * sorted order. Modify arr1 so that it contains the first N
 *  elements and modify arr2 so that it contains the last M 
 * elements.

Examples

Example 1:

Input: 
n = 4, arr1[] = [1 4 8 10] 
m = 5, arr2[] = [2 3 9]

Output: 
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:
After merging the two non-decreasing arrays, we get, 1,2,3,4,
8,9,10.

Example2:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]

Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]

Explanation:
After merging the two non-decreasing arrays, we get, 0 1 2 3 
5 6 7 8 9.
 */
import java.util.Arrays;

public class MergeArray {
    public static void brute(int[] arr1, int[] arr2, int n, int m) {
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        while (i < n) {
            merged[k++] = arr1[i++];
        }
        while (j < m) {
            merged[k++] = arr2[j++];
        }
        // Copy the first n elements to arr1
        for (i = 0; i < n; i++) {
            arr1[i] = merged[i];
        }
        // Copy the last m elements to arr2
        for (j = 0; j < m; j++) {
            arr2[j] = merged[n + j];
        }
    }

    public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void optimal1(int[] arr1, int[] arr2, int n, int m) {
        int i = n - 1, j = 0;
        while (i >= 0 && j <= m - 1) {
            if (arr1[i] > arr2[j]) {
                // Swap the elements if they are out of order:
                swapIfGreater(arr1, arr2, i, j);
                i--;
                j++;
            } else
                break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int k = 0; k < n; k++) {
            System.out.print(arr1[k] + " ");
        }
        System.out.println();
        for (int l = 0; l < m; l++) {
            System.out.print(arr2[l] + " ");
        }
    }

    public static void optimal2(int[] arr1, int[] arr2, int n, int m) {

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                // and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1)
                break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 8, 10 };
        int[] arr2 = { 2, 3, 9 };
        int n = arr1.length;
        int m = arr2.length;
        optimal1(arr1, arr2, n, m);

    }

}
