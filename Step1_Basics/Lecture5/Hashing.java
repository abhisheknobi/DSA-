package Step1_Basics.Lecture5;

import java.util.*;

public class Hashing {

    static void numHashing() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int hashh[] = new int[10];

        for (int i = 0; i < n; i++) {
            hashh[arr[i]]++;
        }
        System.out.println("Enter the number of queries:");
        int q = sc.nextInt();
        while (q-- > 0) {
            int num = sc.nextInt();
            System.out.println("Frequency of " + num + ": ");
            System.out.println(hashh[num]);

        }
        sc.close();

    }

    static void charHashing() {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // precompute:
        int[] hash = new int[13];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int q;
        q = sc.nextInt();
        while (q-- != 0) {
            int number;
            number = sc.nextInt();
            // fetching:
            System.out.println(hash[number]);
        }
        sc.close();
    }

    public static void main(String[] args) {
        charHashing();

    }

}
