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
        /* Brute force Thought Process:
         * You start with the number you expect: k = 1

Every time the array contains that number → increase k

The first time the array has a number bigger than k,
that means k is missing.

Return k.
         */
    }



    public int optimal(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);//here mid+1 is because whole numbers start from 1
            if (missing < k) {//we need to find the range where missing numbers are less than k
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;//Derivation of this formula is explained in the thought process below
        /*
         * arr[high]=7     missing=3     more=2
         * so basically we need to add the more numbers to arr[high] to get the kth missing number
         * kth missing number=arr[high]+more
         * -> arr[high]+(k-missing)
         * -> arr[high]+(k-(arr[high]-(high+1)))
         * -> k+high+1 which can also be written as k+low since low=high+1 at the end of the loop
         */
    }
    /*Optimal Thought Process:
    Lets take for exampe arr={2,3,4,7,11}, k=5
    We can see that:
    Index:      0 1 2 3 4
    Value:      2 3 4 7 11
    Missing:    1 1 1 3 6
    So, at index 4, we have 6 missing numbers till arr[4].
    Now we can apply binary search to find the largest index
    such that number of missing numbers till that index is less than k.
    Finally, the answer will be k + index.

     * 
     */

    public static void main(String[] args) {
        KthMissing obj = new KthMissing();
        int[] arr = { 4, 7, 9, 10 };
        int k = 3;
        System.out.println(obj.brute(arr, k));
        System.out.println(obj.optimal(arr, k));
    }
}
