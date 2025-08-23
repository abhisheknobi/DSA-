package Step3_Arrays.Hard;

/*
 * Problem Statement: Given an array of intervals, merge all the overlapping 
 * intervals and return an array of non-overlapping intervals.

Examples

Example 1:
Example 1: 

Input: intervals=[[1,3],[2,6],[8,10],[15,18]]

Output: [[1,6],[8,10],[15,18]]

Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge
 them to form [1,6]
 intervals.

Example 2:

Input: [[1,4],[4,5]]

Output: [[1,5]]

Explanation: Since intervals [1,4] and [4,5] are overlapping we can merge
 them to form [1,5].

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static List<List<Integer>> brute(int[][] arr) {
        int n = arr.length; // size of the array
        // sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) { // select an interval:
            int start = arr[i][0];
            int end = arr[i][1];

            // Skip all the merged intervals:
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // check the rest of the intervals:
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    public static List<List<Integer>> optimal(int[][] arr) {
        int n = arr.length; // size of the array
        // sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // if the current interval does not
            // lie in the last interval:
            // If the answer list is empty or the current interval does not overlap with the
            // last interval in ans
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                // Add the current interval as a new interval
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                // Otherwise, there is overlap, so merge the current interval with the last one
                int lastEnd = ans.get(ans.size() - 1).get(1);
                ans.get(ans.size() - 1).set(1, Math.max(lastEnd, arr[i][1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
        List<List<Integer>> ans = optimal(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }

}
