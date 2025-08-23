package Step3_Arrays.Easy;

public class MissingNo {

    static int missing(int arr[], int n) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < n - 1; i++) {// n-1 because the array contains n-1 elements (one element is missing)
            xor1 = xor1 ^ arr[i];
            xor2 = xor2 ^ (i + 1);
        }
        xor2 = xor2 ^ n;
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        System.out.println(missing(arr, 5));
    }

}
