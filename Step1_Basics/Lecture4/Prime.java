package Step1_Basics.Lecture4;

import java.util.*;

public class Prime {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> printPrime(int n) {
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                p.add(i);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        System.out.println(isPrime(n) ? n + " is prime" : n + " is not prime");
        ArrayList<Integer> primes = printPrime(n);
        System.out.println("Primes less than or equal to " + n + " are: ");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
        sc.close();
    }
}
