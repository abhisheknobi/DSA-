package Step1_Basics.Lecture4;

import java.util.*;

public class Factor {

    public static int hcf(int n1, int n2) {
        int n = Math.min(n1, n2);
        int gcd = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;

    }

    public static int calculateLCM(int a, int b) {
        int lcm = Math.max(a, b);
        while (true) {
            if (lcm % a == 0 && lcm % b == 0) {
                break;
            }
            lcm++;
        }
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.print("HCF of " + n1 + "and" + n2 + " are: ");
        System.out.println(hcf(n1, n2));
        System.out.print("LCM of " + n1 + "and" + n2 + " are: ");
        System.out.println(calculateLCM(n1, n2));
    }
}
