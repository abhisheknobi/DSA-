package Step10_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a binary array nums and an integer goal, return the number of non-empty
subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 */
public class BinarySubArraySum {
    static void main() {
        int[] nums={1,0,1,0,1};
        int goal=2;
        int []nums2={0,0,0,0,0};
        int goal2=0;
        System.out.println(brute(nums2,goal2));
    }
    static int brute(int[]nums,int k){
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k)
                    count++;
                if(sum>k)
                    break;

            }
        }
        return count;
    }
    static int better(int[]nums,int k){
        Map<Integer,Integer> mpp=new HashMap<>();
        int n=nums.length;
        int presum=0;
        int count=0;
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            presum+=nums[i];

            if(mpp.containsKey(presum-k)){
                count+=mpp.get(presum-k);
            }
            mpp.put(presum,mpp.getOrDefault(presum,0)+1);
        }
        return count;
    }
}
