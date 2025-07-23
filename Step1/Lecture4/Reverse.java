package Step1.Lecture4;
import java.util.*;
public class Reverse {
    public static int reverse(int n) {
        int rev=0;
        while(n>0){
            int digit=n%10;
            rev=10*rev+digit;
            n/=10;
            
        }return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Reversed number: " + reverse(n));
    }
}
