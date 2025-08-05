package Step3.Hard;

/*
Problem Statement: Given an array of N integers. 
Find the elements that appear more than N/3 times in the 
array. If no such element exists, return an empty vector.

Pre-requisite: Majority Element(>N/2 times)

Examples

Example 1:
Input Format: N = 5, array[] = {1,2,2,3,2}
Result: 2
Explanation: Here we can see that the Count(1) = 1,
 Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 
 is greater than N/3 times. Hence, 2 is the answer.

Example 2:
Input Format:  N = 6, array[] = {11,33,33,11,33,11}
Result: 11 33
Explanation: Here we can see that the Count(11) = 3
 and Count(33) = 3. Therefore, the count of both 11 and 33
  is greater than N/3 times. Hence, 11 and 33 is the answer.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Majority {
    public static List<Integer> brute(int arr[]) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (res.size() == 0 || !res.contains(arr[i])) {
                int count = 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
                if (count > n / 3) {
                    res.add(arr[i]);
                }
            }
        }
        if (res.size() == 0) {
            return res; // Return empty list if no element found
        }
        return res;
    }

    public static List<Integer> better(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : mpp.keySet()) {
            if (mpp.get(key) > n / 3) {
                res.add(key);
            }
        }
        if (res.size() == 0) {
            return res; // Return empty list if no element found
        }
        return res;
    }

    public static List<Integer> optimal(int v[]) {
        int n = v.length; // size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != v[i]) {
                /*
                 * the reason why we are checking el2 != v[i] is
                 * to avoid the case where both elements are same.
                 * In that case, we will not be able to distinguish
                 * between the two elements.
                 * 
                 * for example, if we have an array like
                 * {2,1,1,3,1,4,5,6} then we will not be able to
                 * distinguish between 1 and 2, so we will not
                 * be able to find the majority element.
                 * That is because the moment we encounter 1 after 3
                 * we will set cnt1 = 1 and el1 = 1, where
                 * and el2 is already holding 1, so we will not be able to
                 * distinguish between the two elements.
                 * 
                 */

                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            } else if (v[i] == el1)
                cnt1++;
            else if (v[i] == el2)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1)
                cnt1++;
            if (v[i] == el2)
                cnt2++;
        }

        int mini = (int) (n / 3) + 1;
        if (cnt1 >= mini)
            ls.add(el1);
        if (cnt2 >= mini)
            ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        // Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return ls;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 2, 2, 2, };
        int[] arr2 = { 11, 33, 33, 11, 33, 11 };
        List<Integer> res = new ArrayList<>();
        res = better(arr2);
        if (res.size() == 0) {
            System.out.println("No element found");
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
        }
    }

}
