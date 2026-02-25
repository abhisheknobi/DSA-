package Step9_StackQueue.monotonic_stack;

/**
 * Problem Statement: Given an array of integers arr of size n,
 *  calculate the sum of the minimum value in each (contiguous)
 * \ subarray of arr. Since the result may be large, return the answer modulo 10⁹ +7.

Examples
Example 1:
Input:
 arr = [3, 1, 2, 5]
Output:
 18
Explanation:
 The minimum of subarrays: [3], [1], [2], [5], [3, 1], [1, 2],
  [2, 5], [3, 1, 2], [1, 2, 5], [3, 1, 2, 5] are
   3, 1, 2, 5, 1, 1, 2, 1, 1, 1 respectively and their sum is 18.

Example 2:
Input:
 arr = [2, 3, 1]
Output:
 10
Explanation:
 The minimum of subarrays: [2], [3], [1], [2,3], [3,1], [2,3,1]
  are 2, 3, 1, 2, 1, 1 respectively and their sum is 10.
 */
public class SumMinSubaaray {
      // Function to find the sum of the minimum value in each subarray
    public static int brute(int[] arr) {
        // Size of the array
        int n = arr.length;

        // Modulo value to prevent integer overflow
        int mod = (int)1e9 + 7;

        // Variable to store the total sum
        int sum = 0;

        // Traverse each starting index of subarrays
        for (int i = 0; i < n; i++) {
            // Initialize the minimum as the current element
            int mini = arr[i];

            // Traverse all subarrays starting at index i
            for (int j = i; j < n; j++) {
                // Update the minimum in the current subarray
                mini = Math.min(mini, arr[j]);

                // Add the current minimum to the total sum
                sum = (sum + mini) % mod;
            }
        }

        // Return the total computed sum
        return sum;
    }



    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 1, 2, 5};
        // Call the function to get the sum of minimums
        int ans = brute(arr);

        // Print the result
        System.out.println("The sum of minimum value in each subarray is: " + ans);
    }
}
    

