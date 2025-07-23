package Step3.Medium;

public class KadaneSum {
    //Kadane's Algorithm to find the maximum subarray sum
    public static long maxSubArray(int[]arr ){
         long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;
        int n = arr.length;
        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i; // starting index

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    }
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(arr));
    }
}

/*
 * Kadane's Algorithm is a dynamic programming algorithm that solves the
 * problem of finding the maximum sum of a contiguous subarray in an array of integers.
 * It works by iterating through the array and maintaining a running sum of the current subarray.
 * If the running sum becomes negative, it is reset to zero, as a negative sum would
 * not contribute positively to the maximum sum.
 * The algorithm keeps track of the maximum sum encountered so far and returns it at the end.
 * The time complexity of Kadane's Algorithm is O(n), where n is the number of elements in the array.
 * The space complexity is O(1) as it uses a constant amount of extra space.
 */
