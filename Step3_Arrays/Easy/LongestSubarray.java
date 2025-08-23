package Step3_Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {

    // function to find longest subarray with negative numbers using Hashing
    public static int longSubarray(int arr[], int k) {
        int n = arr.length;
        Map<Long, Integer> map = new HashMap<>();
        int maxlen = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k)
                maxlen = Math.max(maxlen, i + 1);

            long rem = sum - k;

            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxlen = Math.max(maxlen, len);
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxlen;
    }

    public static int longSubarrayPos(int a[], int k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n)
                sum += a[right];
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { -1, 1, 1 };
        int k = 1;
        System.out.println(longSubarray(arr, k));
    }

}
