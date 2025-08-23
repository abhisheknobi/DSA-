package Step2_Sorting;

public class SelectionSort {
    /*
     * select minimum from the array and swap it with the first element
     * now we know that the first element is sorted
     * now select the minimum form the array excluding the first element and swap it
     * with the second eleement
     * now we know that the first two elements are sorted
     * continue this process till the last element
     * 
     */

    static void selection_sort(int arr[], int n) {// {13, 46, 24, 52, 20, 9}
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            // swap
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }

        System.out.println("After selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        int arr[] = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;
        System.out.println("Before selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        selection_sort(arr, n);
    }
}
