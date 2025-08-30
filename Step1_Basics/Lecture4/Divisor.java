package Step1_Basics.Lecture4;

import java.util.*;

public class Divisor {
    public static ArrayList<Integer> getDivisors(int a) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                divisors.add(i);
                if (i != a / i) {
                    // For example, if a = 16 and i = 4, then a / i = 4.
                    // If we blindly add both i and a / i, we'd add 4 twice, leading to duplicates
                    // in the list.
                    // The condition if (i != a / i) ensures that we only add a / i if it is
                    // different from i, preventing duplicates.
                    divisors.add(a / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        ArrayList<Integer> divisors = getDivisors(n);
        System.out.println("Divisors of " + n + " are: ");
        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }
        sc.close();
    }
}
