package Step7_Recursion.Lec_2;
/*
 * Given an array nums and an integer k.Return the number 
 * of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.

Examples
Example 1:
Input : nums = [4, 9, 2, 5, 1] , k = 10
Output : 2
Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].

Example 2:
Input : nums = [4, 2, 10, 5, 1, 3] , k = 5
Output : 3
Explanation : The possible subsets with sum k are [4, 1] , [2, 3] , [5].
 */
public class CountSubSequence {
    public static int countSubsequences(int[] nums, int n, int k, int index, int currentSum) {
        // Base case: If we have considered all elements
        if (index == n) {
            // Check if the current sum equals k
            return currentSum == k ? 1 : 0;
        }

        // Include the current element in the subsequence
        int includeCount = countSubsequences(nums, n, k, index + 1, currentSum + nums[index]);

        // Exclude the current element from the subsequence
        int excludeCount = countSubsequences(nums, n, k, index + 1, currentSum);

        // Return the total count of subsequences
        return includeCount + excludeCount;
    }

    public static boolean countSubsequence(int[] nums, int n, int k,int index, int currentSum) {
        if(index==n){
            if(currentSum==k){
                return true;
        }
    }
        // Include the current element
        boolean include = countSubsequence(nums, n, k, index + 1, currentSum + nums[index]);
        // Exclude the current element
        boolean exclude = countSubsequence(nums, n, k, index + 1, currentSum);
        return include || exclude;
    }

    public static void countSubsequencePrint(int[] nums, int n, int k, int index, int currentSum, String path) {
        if (index == n) {
            if (currentSum == k) {
                System.out.println(path);
            }
            return;
        }

        // Include the current element
        countSubsequencePrint(nums, n, k, index + 1, currentSum + nums[index], path + nums[index] + " ");

        // Exclude the current element
        countSubsequencePrint(nums, n, k, index + 1, currentSum, path);
    }

    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 5, 1};
        int k = 10;
        int n = nums.length;

        int totalCount = countSubsequences(nums, n,k,0,0);
        countSubsequencePrint(nums, n, k, 0, 0, "");
        System.out.println("Total Subsequences with sum " + k + " : " + totalCount);
    }
}
