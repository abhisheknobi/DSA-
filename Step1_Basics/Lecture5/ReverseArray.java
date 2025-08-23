package Step1_Basics.Lecture5;

public class ReverseArray {
    public static void printArray(int arr[]) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }

    public static void reverse1(int arr[], int i, int n) {// 2 pointer approach
        while (i < n) {

            int temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
            i++;
            n--;
        }
    }

    public static void reverse2(int arr[], int i, int n) {// recursive approach
        if (i >= n) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[n];
        arr[n] = temp;
        reverse2(arr, i + 1, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        reverse2(arr, 0, n - 1);
        printArray(arr);
    }
}
