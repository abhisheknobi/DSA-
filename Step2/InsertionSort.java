package Step2;

public class InsertionSort {
/*
 * It takes one element from the array and places it in its correct position
 */
    static void insertion(int arr[], int n) {
        static void insertion_sort(int[] arr, int n) {
            for (int i = 0; i <= n - 1; i++) {
                int j = i;
                while (j > 0 && arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    j--;
                }
            }
    
            System.out.println("After insertion sort: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before Using insertion Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        insertion_sort(arr, n);
    }
    
}
