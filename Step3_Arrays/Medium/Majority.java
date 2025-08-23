package Step3_Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class Majority {
    public static int major(int arr[]) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (mpp.containsKey(arr[i]))
                mpp.put(arr[i], mpp.get(arr[i]) + 1);
            else
                mpp.put(arr[i], 1);
        }
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (arr.length / 2)) {
                return it.getKey();

            }
        }
        return -1;
    }

    // Moores Voting Algorithm
    public static int major2(int v[]) {
        int n = v.length;
        int cnt = 0; // count
        int el = 0; // Element

        // applying the algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = v[i];
            } else if (el == v[i])
                cnt++;
            else
                cnt--;
        }

        // checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el)
                cnt1++;
        }

        if (cnt1 > (n / 2))
            return el;
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 2, 2, 1, 2, 2 };
        System.out.println(major2(arr));
    }
}
/*
 * Moores Voting Algorithm:
 * The idea is to maintain a count of the current candidate for majority
 * element.
 * If the count becomes zero, we set the current element as the new candidate
 * and reset the count to 1.
 * If the current element is equal to the candidate, we increment the count.
 * If it is not equal, we decrement the count.
 * At the end, we check if the candidate is indeed the majority element by
 * counting its occurrences in the array.
 */
