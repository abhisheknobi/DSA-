package Step3_Arrays.Hard;

/*
 * Problem Statement: Given an array that contains both negative and
 *  positive integers, find the maximum product subarray.

Examples

Example 1:
Input:
 Nums = [1,2,3,4,5,0]
Output:
 120
Explanation:
 In the given array, we can see 1×2×3×4×5 gives maximum product value.


Example 2:
Input:
 Nums = [1,2,-3,0,-4,-5]
Output:
 20
Explanation:
 In the given array, we can see (-4)×(-5) gives maximum product value.
 */
public class MaxProd {
    static int maxProductSubArray(int arr[]) {
        int result = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            int p = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                result = Math.max(result, p);
                p *= arr[j];
            }
            result = Math.max(result, p);
        }
        return result;
    }

    public static int optimal(int[] arr) {
        int prefix = 1;
        int suffix = 1;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix *= arr[i];
            suffix *= arr[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        System.out.println("Maximum product subarray is: " + optimal(arr));
    }

}
