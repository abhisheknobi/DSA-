package Step7_Recursion.Lec_2;
/*
 * Find all valid combinations of k numbers that sum up to 
 * n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must
 not contain the same combination twice, and the combinations may
  be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum
 we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid 
 combination.
 */
import java.util.ArrayList;
import java.util.List;
class Solution {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(k, 1, n, new ArrayList<>(), ans);
        return ans; 
    }

    public static void findCombination(int k, int num, int target, ArrayList<Integer> lst, List<List<Integer>> ans) {
        // If target is reached and k elements are used
        if (target == 0 && k == 0) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        for (int i = num; i < 10; i++) {
            if (i > target || k <= 0) break; // Prune unnecessary calls
            lst.add(i); // Choose the current number
            findCombination(k - 1, i + 1, target - i, lst, ans); // Recurse
            lst.remove(lst.size() - 1); // Backtrack
        }
    }
    public static void main(String[] args) {
        int k = 3, n = 9;
        List<List<Integer>> result = combinationSum3(k, n);
        System.out.println(result);
    }
}
