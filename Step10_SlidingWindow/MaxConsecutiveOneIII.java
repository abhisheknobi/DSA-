package Step10_SlidingWindow;
/*
Given a binary array nums and an integer k, return the maximum number of
consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
public class MaxConsecutiveOneIII {
    public static int brute(int[] nums, int k) {
        int n=nums.length;

        int maxlen=0;
        for(int i=0;i<n;i++){
            int zeros=0;
            for(int j=i;j<n;j++){
                if(nums[j]==0){
                    zeros++;
                }
                if(zeros<=k){
                    int len=j-i+1;
                    maxlen=Math.max(len,maxlen);
                }
                else{
                    break;
                }
            }
        }
        return maxlen;
    }
//uses O(2n) time complexity
    public static  int better(int[] nums, int k) {

        // Left pointer for the window
        int left = 0;

        // Counter for zeros in the window
        int zeros = 0;

        // Variable to store maximum window length
        int maxLen = 0;

        // Right pointer expands the window
        for (int right = 0; right < nums.length; right++) {

            // If element is zero, increase the zero count
            if (nums[right] == 0) {
                zeros++;
            }

            // If zero count exceeds k, shrink the window
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                // Move left pointer
                left++;
            }

            // Update the max length of the valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Return the result
        return maxLen;
    }

    static int optimal(int[]nums,int k){
        int left = 0, right = 0, zeros = 0, maxLen = 0;

        while(right<nums.length){
            if(nums[right]==0){
                zeros++;
            }

            if(zeros<k){
                if(nums[left]==0) zeros--;
                left++;
            }

            if(zeros<=k)
                maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }

    static void main() {
       int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
       int k=2;
        System.out.println(better(nums,k));
    }
}
