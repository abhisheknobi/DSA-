package Step1_Basics.Lecture4;

import java.util.*;

public class CountDigits {

    public static int cd(int n) { // brute force approach
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static int cd2(int n) { // logarithmic approach
        return (int) (Math.log10(n) + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Number of digits: " + cd(n));
    }
}

/*
 * The time complexity of the brute force approach is O(log n) because we are
 * dividing the number by 10
 * in each iteration until it becomes 0. The space complexity is O(1) because we
 * are using a constant amount of space to store the count variable.
 * 
 * 
 */