package Step3.Medium;

import java.util.Arrays;

public class LongConsecSeq {
    /*
     * Problem Statement: You are given an array of ‘N’ integers.
     * You need to find the length of the longest sequence which contains
     * the consecutive elements.
     * Examples
     * 
     * 
     * Example 1:
     * 
     * Input: [100, 200, 1, 3, 2, 4]
     * 
     * Output: 4
     * 
     * Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
     * 
     * Input: [3, 8, 5, 7, 6]
     * 
     * Output: 4
     * 
     * Explanation: The longest consecutive subsequence is 5, 6, 7, and 8.
     */
    public static boolean lsearch(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return true;
        }
        return false;
    }

    public static int brute(int[] arr) {
        int n = arr.length;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int current = arr[i];
            while (lsearch(arr, current + 1)) {
                cnt++;
                current++;
            }
            if (cnt > maxlen)
                maxlen = cnt;
        }
        return maxlen;

    }

    public static int better(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        // sort the array:
        Arrays.sort(a);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        // find longest sequence:
        for (int i = 0; i < n; i++) {
            if (a[i] - 1 == lastSmaller) {
                // a[i] is the next element of the
                // current sequence.
                cnt += 1;
                lastSmaller = a[i];
            } else if (a[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = a[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    public static int optimal(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        // Create a set to store unique elements
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longestStreak = 0;

        // Iterate through each number in the set
        for (int num : set) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int arr[] = { 102, 4, 100, 1, 103, 2, 101 };
        System.out.println("Longest Consecutive Sequence Length: " + optimal(arr));
    }
}
