package Step4_BS.Lecture2;
/*
 * Problem Statement: You are the owner of a Shipment company.
 *  You use conveyor belts to ship packages from one port to another.
 *  The packages must be shipped within 'd' days.
The weights of the packages are given in an array 'of weights'.
 The packages are loaded on the conveyor belts every day in the
  same order as they appear in the array. The loaded weights must
   not exceed the maximum weight capacity of the ship.
Find out the least-weight capacity so that you can ship all the
 packages within 'd' days.

Examples

Example 1:
Input Format: N = 5, weights[] = {5,4,5,2,3,4,5,6}, d = 5
Result: 9
Explanation: If the ship capacity is 9, the shipment will be done
 in the following manner:
Day         Weights            Total
1        -       5, 4          -        9
2        -       5, 2          -        7
3        -       3, 4          -        7
4        -       5              -        5
5        -       6              -        6
So, the least capacity should be 9.

Example 2:

Input Format: N = 10, weights[] = {1,2,3,4,5,6,7,8,9,10}, d = 1
Result: 55
Explanation: We have to ship all the goods in a single day. So, 
the weight capacity should be the summation of all the weights i.e. 55.

 */

public class Ship {
    public static int findDays(int[] weights, int cap) {
        int days = 1; // First day.
        int load = 0;
        int n = weights.length; // size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1; // move to next day
                load = weights[i]; // load the weight.
            } else {
                // load the weight on the same day.
                load += weights[i];
            }
        }
        return days;
    }

    public static int brute(int[] weights, int days) {
        // Find the maximum and the summation:
        int maxi = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            maxi = Math.max(maxi, weights[i]);
        }

        for (int i = maxi; i <= sum; i++) {
            if (findDays(weights, i) <= days) {
                return i;
            }
        }
        // dummy return statement:
        return -1;
    }

    public static int optimal(int[] weights, int days) {
        // Find the maximum and the summation:
        int maxi = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            maxi = Math.max(maxi, weights[i]);
        }

        int low = maxi, high = sum, mid = 0;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (findDays(weights, mid) <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = { 5, 4, 5, 2, 3, 4, 5, 6 };
        int days = 5;
        System.out.println(brute(weights, days));
    }
}
