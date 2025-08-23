package Step3_Arrays.Easy;

public class ZeroEnd {
    public static void moveZeros(int arr[]) {
        int n = arr.length;
        int j = -1;
        int i = 0;
        for (i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i; // first occurrence of zero
                break;
            }
        }
        for (i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        System.out.println("Before Moving Zeros:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        moveZeros(arr);
        System.out.println("After Moving Zeros:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
