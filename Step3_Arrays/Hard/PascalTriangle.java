package Step3_Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Statement: This problem has 3 variations. They are stated below:

Variation 1: Given row number r and column number c.
 Print the element at position (r, c) in Pascal’s triangle.

Variation 2: Given the row number n. 
Print the n-th row of Pascal’s triangle.

Variation 3: Given the number of rows n. 
Print the first n rows of Pascal’s triangle

Example 1:
Input Format: N = 5, r = 5, c = 3
Result: 6 (for variation 1)
1 4 6 4 1 (for variation 2)

1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1    (for variation 3)

Explanation: There are 5 rows in the output matrix. Each row is formed using the logic of Pascal’s triangle.

Example 2:
Input Format: N = 1, r = 1, c = 1
Result: 1 (for variation 1)
    1 (for variation 2)
    1  (for variation 3)
Explanation: The output matrix has only 1 row.
 */
public class PascalTriangle {
    /*
     * This is the traditional approach to calculate the value at position (r, c) in
     * Pascal's triangle.
     * It uses the formula C(r-1, c-1) = (r-1)! / ((c-1)! * (r-c)!)
     * where C(n, k) is the binomial coefficient.
     * 
     * 
     * public static int factorial(int n) {
     * if (n == 0 || n == 1)
     * return 1;
     * int fact = 1;
     * for (int i = 2; i <= n; i++) {
     * fact *= i;
     * }
     * return fact;
     * }
     * 
     * public static int var1(int r, int c) {
     * return factorial(r - 1) / (factorial(c - 1) * factorial(r - c));
     * 
     * }
     */
    public static long nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static long var1(int r, int c) {
        return nCr(r - 1, c - 1);
        // This calculates the value at position (r, c) in Pascal's
        // triangle using the nCr formula.
    }

    public static void var2(int n) {// printing the nth row of Pascal's triangle
        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }

    public static List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // inserting the 1st element

        // calculate the rest of the elements:
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> var3(int n) {// printing the first n rows of Pascal's triangle
        List<List<Integer>> ans = new ArrayList<>();

        // store the entire pascal's triangle:
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5; // Number of rows
        System.out.println(var1(5, 3));
        var2(5);
        List<List<Integer>> pascalTriangle = var3(n);
        for (List<Integer> row : pascalTriangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
