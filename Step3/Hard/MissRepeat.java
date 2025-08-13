package Step3.Hard;

/*
 * Problem Statement: You are given a read-only array of N
 *  integers with values also in the range [1, N] both inclusive. 
 * Each integer appears exactly once except A which appears twice
 *  and B which is missing. The task is to find the repeating and
 *  missing numbers A and B where A repeats twice and B is missing.

Examples

Example 1:
Input Format:  array[] = {3,1,2,5,3}
Result: {3,4)
Explanation: A = 3 , B = 4 
Since 3 is appearing twice and 4 is missing

Example 2:
Input Format: array[] = {3,1,2,5,4,6,7,5}
Result: {5,8)
Explanation: A = 5 , B = 8 
Since 5 is appearing twice and 8 is missing
 */
public class MissRepeat {
public static int[] brute(int []arr)
{
    int n=arr.length;
    int[] result = new int[2]; // result[0] for repeating, result[1] for missing
    for(int i=1;i<n;i++)
}

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 3 };
        int[] result = brute(arr);
        System.out.println("Missing: " + result[0] + ", Repeating: " + result[1]);
    }

}
