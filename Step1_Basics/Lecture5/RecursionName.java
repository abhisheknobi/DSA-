package Step1_Basics.Lecture5;

public class RecursionName {
    public static void printName(int i, int n) {
        if (i > n)
            return;
        System.out.println("Abhishek");
        printName(i + 1, n);
    }

    public static void printNum(int i, int n) {
        if (i > n)
            return;
        System.out.println(i);
        printNum(i + 1, n);
    }

    // print from n to 1 using backtracking
    public static void numBackRev(int i, int n) {
        if (i > n)
            return;
        numBackRev(i + 1, n);
        System.out.println(i);
    }

    // print from 1 to n using backtracking
    public static void NumBack(int i, int n) {
        if (i < 1)
            return;
        NumBack(i - 1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        printName(0, 05);
        printNum(0, 10);
        numBackRev(1, 4);
        NumBack(4, 4);
    }
}
