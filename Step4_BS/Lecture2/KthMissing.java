package Step4_BS.Lecture2;

public class KthMissing {
    /*
     * Problem Statement: You are given a strictly increasing array
     * ‘vec’ and a positive integer 'k'. Find the 'kth' positive
     * integer missing from 'vec'.
     * 
     * Examples
     * 
     * Example 1:
     * Input Format: vec[]={4,7,9,10}, k = 1
     * Result: 1
     * Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……,
     * and so on. Since 'k' is 1, the first missing element is 1.
     * Example 2:
     * Input Format: vec[]={4,7,9,10}, k = 4
     * Result: 5
     * Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……,
     * and so on. Since 'k' is 4, the fourth missing element is 5.
     */
    public int brute(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;
            else
                break;
        }
        return k;
    }

    public int optimal(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }

    public static void main(String[] args) {
        KthMissing obj = new KthMissing();
        int[] arr = { 4, 7, 9, 10 };
        int k = 3;
        System.out.println(obj.brute(arr, k));
        System.out.println(obj.optimal(arr, k));
    }
}
