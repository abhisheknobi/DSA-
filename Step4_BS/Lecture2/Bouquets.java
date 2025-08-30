package Step4_BS.Lecture2;

/*
 * Problem Statement: You are given 'N’ roses and you are also 
 * given an array 'arr'  where 'arr[i]'  denotes that the 'ith'
 *  rose will bloom on the 'arr[i]th' day.
You can only pick already bloomed roses that are adjacent to 
make a bouquet. You are also told that you require exactly 'k'
 adjacent bloomed roses to make a single bouquet.
Find the minimum number of days required to make at least ‘m' 
bouquets each containing 'k' roses. Return -1 if it is not possible.

Examples

Example 1:
Input Format: N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2,
 k = 3
Result: 12
Explanation: On the 12th the first 4 flowers and the last 3 flowers
 would have already bloomed. So, we can easily make 2 bouquets, one
  with the first 3 and another with the last 3 flowers.

Example 2:
Input Format: N = 5, arr[] = {1, 10, 3, 10, 2}, m = 3, k = 2
Result: -1
Explanation: If we want to make 3 bouquets of 2 flowers each,
 we need at least 6 flowers. But we are given only 5 flowers, 
 so, we cannot make the bouquets.


Let's grasp the question better with the help of an example. 
Consider an array: {7, 7, 7, 7, 13, 11, 12, 7}. We aim to create
 bouquets with k, which is 3 adjacent flowers, and we need to make 
 m, which is 2 such bouquets. Now, if we try to make bouquets on the 
 11th day, the first 4 flowers and the 6th and the last flowers would
  have bloomed. So, we will be having 6 flowers in total on the 11th 
  day. However, we require two groups of 3 adjacent flowers each.
   Although we can form one group with the first 3 adjacent flowers,
    we cannot create a second group. Therefore, 11 is not the answer in this case.


If we choose the 12th day, we can make 2 such groups, one with the first 3 adjacent flowers and the other with the last 3 adjacent flowers. Hence, we need a minimum of 12 days to make 2 bouquets.


 */
public class Bouquets {
    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length;
        int count = 0;
        int num = 0;// number of bouquets
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day)
                count++;
            else {
                num += count / k;
                count = 0;
            }
        }
        num += count / k;
        return num >= m;
    }

    public int brute(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (m * k))
            return -1;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            maxi = Math.max(maxi, bloomDay[i]);
            mini = Math.min(mini, bloomDay[i]);
        }
        int[] ans = new int[2];
        ans[0] = mini;
        ans[1] = maxi;
        for (int i = mini; i <= maxi; i++) {
            if (possible(bloomDay, i, m, k))
                return i;
        }

        return 0;
    }

    public int optimal(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (m * k)) // not enough flowers at all
            return -1;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, bloomDay[i]);
            mini = Math.min(mini, bloomDay[i]);
        }

        int low = mini, high = maxi;
        int ans = -1; // store result only if found
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                ans = mid; // ✅ valid answer
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; // ✅ if no valid day, returns -1
    }

    public static void main(String[] args) {
        int[] bloomDay = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int m = 2;
        int k = 3;
        Bouquets obj = new Bouquets();
        int ans = obj.brute(bloomDay, m, k);
        System.out.println("Minimum number of days required to make at least "
                + m + " bouquets each containing " + k + " roses is: " + ans);

    }

}
