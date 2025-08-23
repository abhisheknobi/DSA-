package Step3_Arrays.Hard;

import java.util.ArrayList;

/*
 
Problem Statement: Given an array of N integers, count the inversion of the 
array (using merge-sort).

What is an inversion of an array? Definition: for all i & j < size of array,
 if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

Examples

Example 1:
Input Format: N = 5, array[] = {1,2,3,4,5}
Result: 0
Explanation: we have a sorted array and the sorted array has 0 inversions as 
for i < j you will never find a pair such that A[j] < A[i]. More clear example:
 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.

Example 2:
Input Format: N = 5, array[] = {5,4,3,2,1}
Result: 10
Explanation: we have a reverse sorted array and we will get the maximum inversions 
as for i < j we will always find a pair such that A[j] < A[i]. Example: 5 has index 
0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3 which will satisfy 
out conditions and for reverse sorted array we will get maximum inversions and that 
 (n)*(n-1) / 2.For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

Example 3:
Input Format: N = 5, array[] = {5,3,2,1,4}
Result: 7
Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and (1,4) as both are not satisfy our condition. 
 */
public class Inversion {
    public static int brute(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Check for all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr

        // Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        // storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); // Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid); // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high); // merging sorted halves
        return cnt;
    }

    public static int optimal(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] array = { 5, 3, 2, 1, 4 };
        int n = array.length;
        int result = optimal(array, n);
        System.out.println("Number of inversions: " + result);
    }
    /*
     * Entire code iteration
     * 01: mergeSort(low=0, high=4) CALLED on segment [5, 3, 2, 1, 4]
     * 02: mid = 2
     * 03: mergeSort(low=0, high=2) CALLED on segment [5, 3, 2]
     * 04: mid = 1
     * 05: mergeSort(low=0, high=1) CALLED on segment [5, 3]
     * 06: mid = 0
     * 07: mergeSort(low=0, high=0) CALLED on segment [5]
     * 08: Base case reached for (low=0, high=0); return 0
     * 09: mergeSort(low=1, high=1) CALLED on segment [3]
     * 10: Base case reached for (low=1, high=1); return 0
     * 
     * 11: merge(low=0, mid=0, high=1) START -- Left=[5], Right=[3]
     * 12: While#1: compare arr[left]=5 (idx 0) vs arr[right]=3 (idx 1)
     * 13: -> arr[left] > arr[right]; append 3 to temp -> [3];
     * cnt += (mid-left+1) = 0-0+1 = 1; new cnt=1; right++
     * 14: Left remains: append arr[0]=5 -> temp [3, 5]; left++
     * 15: Copy-back: arr[0] = temp[0] = 3
     * 16: arr now -> [3, 3, 2, 1, 4]
     * 17: Copy-back: arr[1] = temp[1] = 5
     * 18: arr now -> [3, 5, 2, 1, 4]
     * 19: merge(low=0, mid=0, high=1) END -- cnt=1, result segment -> [3, 5]
     * 20: mergeSort(low=0, high=1) RETURNS cnt=1, array now [3, 5, 2, 1, 4]
     * 
     * 21: mergeSort(low=2, high=2) CALLED on segment [2]
     * 22: Base case reached for (low=2, high=2); return 0
     * 
     * 23: merge(low=0, mid=1, high=2) START -- Left=[3, 5], Right=[2]
     * 24: While#1: compare arr[left]=3 (idx 0) vs arr[right]=2 (idx 2)
     * 25: -> arr[left] > arr[right]; append 2 to temp -> [2];
     * cnt += (mid-left+1) = 1-0+1 = 2; new cnt=2; right++
     * 26: Left remains: append arr[0]=3 -> temp [2, 3]; left++
     * 27: Left remains: append arr[1]=5 -> temp [2, 3, 5]; left++
     * 28: Copy-back: arr[0] = temp[0] = 2
     * 29: arr now -> [2, 5, 2, 1, 4]
     * 30: Copy-back: arr[1] = temp[1] = 3
     * 31: arr now -> [2, 3, 2, 1, 4]
     * 32: Copy-back: arr[2] = temp[2] = 5
     * 33: arr now -> [2, 3, 5, 1, 4]
     * 34: merge(low=0, mid=1, high=2) END -- cnt=2, result segment -> [2, 3, 5]
     * 35: mergeSort(low=0, high=2) RETURNS cnt=3, array now [2, 3, 5, 1, 4]
     * 
     * 36: mergeSort(low=3, high=4) CALLED on segment [1, 4]
     * 37: mid = 3
     * 38: mergeSort(low=3, high=3) CALLED on segment [1]
     * 39: Base case reached for (low=3, high=3); return 0
     * 40: mergeSort(low=4, high=4) CALLED on segment [4]
     * 41: Base case reached for (low=4, high=4); return 0
     * 
     * 42: merge(low=3, mid=3, high=4) START -- Left=[1], Right=[4]
     * 43: While#1: compare arr[left]=1 (idx 3) vs arr[right]=4 (idx 4)
     * 44: -> arr[left] <= arr[right]; append 1 to temp -> [1]; left++
     * 45: Right remains: append arr[4]=4 -> temp [1, 4]; right++
     * 46: Copy-back: arr[3] = temp[0] = 1
     * 47: arr now -> [2, 3, 5, 1, 4]
     * 48: Copy-back: arr[4] = temp[1] = 4
     * 49: arr now -> [2, 3, 5, 1, 4]
     * 50: merge(low=3, mid=3, high=4) END -- cnt=0, result segment -> [1, 4]
     * 51: mergeSort(low=3, high=4) RETURNS cnt=0, array now [2, 3, 5, 1, 4]
     * 
     * 52: merge(low=0, mid=2, high=4) START -- Left=[2, 3, 5], Right=[1, 4]
     * 53: While#1: compare arr[left]=2 (idx 0) vs arr[right]=1 (idx 3)
     * 54: -> arr[left] > arr[right]; append 1 to temp -> [1];
     * cnt += (mid-left+1) = 2-0+1 = 3; new cnt=3; right++
     * 55: While#2: compare arr[left]=2 (idx 0) vs arr[right]=4 (idx 4)
     * 56: -> arr[left] <= arr[right]; append 2 to temp -> [1, 2]; left++
     * 57: While#3: compare arr[left]=3 (idx 1) vs arr[right]=4 (idx 4)
     * 58: -> arr[left] <= arr[right]; append 3 to temp -> [1, 2, 3]; left++
     * 59: While#4: compare arr[left]=5 (idx 2) vs arr[right]=4 (idx 4)
     * 60: -> arr[left] > arr[right]; append 4 to temp -> [1, 2, 3, 4];
     * cnt += (mid-left+1) = 2-2+1 = 1; new cnt=4; right++
     * 61: Left remains: append arr[2]=5 -> temp [1, 2, 3, 4, 5]; left++
     * 62: Copy-back: arr[0] = temp[0] = 1
     * 63: arr now -> [1, 3, 5, 1, 4]
     * 64: Copy-back: arr[1] = temp[1] = 2
     * 65: arr now -> [1, 2, 5, 1, 4]
     * 66: Copy-back: arr[2] = temp[2] = 3
     * 67: arr now -> [1, 2, 3, 1, 4]
     * 68: Copy-back: arr[3] = temp[3] = 4
     * 69: arr now -> [1, 2, 3, 4, 4]
     * 70: Copy-back: arr[4] = temp[4] = 5
     * 71: arr now -> [1, 2, 3, 4, 5]
     * 72: merge(low=0, mid=2, high=4) END -- cnt=4, result segment -> [1, 2, 3, 4,
     * 5]
     * 
     * 73: mergeSort(low=0, high=4) RETURNS cnt=7, array now [1, 2, 3, 4, 5]
     * 
     * 
     * 
     * 
     * This is for tranferring the sorted elements back to the original array.
     * Let’s say:
     * 
     * low = 2, high = 4
     * 
     * temp = [1, 4, 5] (sorted merged result)
     * 
     * Original arr (before copying back): [5, 3, 1, 4, 5]
     * 
     * Copy step-by-step:
     * | i (arr index) | i - low (temp index) | arr\[i] before | temp\[i - low] |
     * arr\[i] after |
     * | ------------- | -------------------- | -------------- | -------------- |
     * ------------- |
     * | 2 | 0 | 1 | 1 | 1 |
     * | 3 | 1 | 4 | 4 | 4 |
     * | 4 | 2 | 5 | 5 | 5 |
     * 
     */
}
