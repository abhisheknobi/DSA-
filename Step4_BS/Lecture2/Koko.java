package Step4_BS.Lecture2;package Step4_BInarySearch.Lecture2;
package Step4_BinarySearch.Lecture2;

/*
 * Koko loves to eat bananas. There are n piles of bananas,
 *  the ith pile has piles[i] bananas. The guards have gone 
 * and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. 
 hour, she chooses some pile of bananas and eats k bananas 
 from that pile. If the pile has less than k bananas, she 
 eats all of them instead and will not eat any more bananas
  during this hour.

Koko likes to eat slowly but still wants to finish eating 
all the bananas before the guards return.

Return the minimum integer k such that she can eat all the
 bananas within h hours.


Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 
 */
import java.util.Arrays;
import java.lang.Math;

public class Koko {
    public static int maxElement(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);

        }
        return maxi;
    }

    public static int requireTime(int[] piles, int time) {
        int n = piles.length;
        int tot = 0;
        for (int i = 0; i < n; i++) {
            tot += Math.ceil((double) piles[i] / (double) time);
        }
        return tot;
    }

    public int brute(int[] piles, int h) {
        int n = piles.length;
        int maxi = maxElement(piles);
        for (int i = 0; i <= maxi; i++) {
            if (requireTime(piles, i) <= h)
                return i;
        }
        return 0;
    }

    public static int minimumRateToEatBananas(int[] v, int h) {
        Arrays.sort(v);
        int low = 1, high = maxElement(v);

        // apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = requireTime(v, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        Koko obj = new Koko();
        int ans = obj.brute(piles, h);
        System.out.println("The minimum integer k such that she can eat all the bananas within h hours is: " + ans);
    }

}
