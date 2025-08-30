package Step1_Basics.Lecture4;

import java.util.*;

public class Reverse {
    public static int reverse(int x) {
        int rev = 0;
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        while (x > 0) {
            int rem = x % 10;
            x /= 10;

            // Check for overflow before multiplying and adding
            if (rev > (Integer.MAX_VALUE - rem) / 10) {
                return 0; // Return 0 on overflow (LeetCode style)
            }

            rev = rev * 10 + rem;
        }

        return rev * sign;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Reversed number: " + reverse(n));
        sc.close();
    }
}
