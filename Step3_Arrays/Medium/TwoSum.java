package Step3_Arrays.Medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

    public static int[] sum(int arr[], int target) {
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int rem = target - arr[i];
            if (map.containsKey(rem)) {
                ans[0] = map.get(rem);
                ans[1] = i;
            }
            map.put(arr[i], i);

        }
        return ans;
    }

    // 2 pointer approach
    public static int[] sum2(int arr[], int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        while (left < right) {
            int sum = temp[left] + temp[right];
            if (sum == target) {
                ans[0] = left;
                ans[1] = right;
                // find the original indices
                for (int i = 0; i < n; i++) {
                    if (arr[i] == temp[left]) {
                        ans[0] = i;
                        break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (arr[i] == temp[right] && i != ans[0]) {
                        ans[1] = i;
                        break;
                    }
                }
                return ans;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 5, 8, 11 };
        int target = 14;
        int[] result = sum2(arr, target);
        if (result[1] != -1 && result[0] != -1) {
            System.out.println(
                    "Indices of the two numbers that add up to " + target + " are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers add up to " + target);
        }
    }
}
