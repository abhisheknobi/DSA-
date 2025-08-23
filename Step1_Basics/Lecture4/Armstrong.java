package Step1_Basics.Lecture4;

import java.util.Scanner;

public class Armstrong {

    public static boolean check(int n) {
        int sum = 0;
        int temp = n;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 3);
            n /= 10;
        }
        return sum == temp ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(check(n));

    }

}
