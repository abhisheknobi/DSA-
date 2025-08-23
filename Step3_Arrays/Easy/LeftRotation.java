package Step3_Arrays.Easy;

public class LeftRotation {

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void lr(int arr[], int d) {
        int n = arr.length;

        if (arr == null || arr.length == 0 || d <= 0)
            return;
        d = d % n;

        LReverse(arr, 0, d - 1);
        LReverse(arr, d, n - 1);
        LReverse(arr, 0, n - 1);

    }

    public static void LReverse(int arr[], int start, int end) {
        while (start < end) {
            arr[start] = arr[start] + arr[end];
            arr[end] = arr[start] - arr[end];
            arr[start] = arr[start] - arr[end];
            start++;
            end--;
        }
    }

    public static void rr(int arr[], int d) {
        int n = arr.length;
        if ((arr == null) || (arr.length == 0) || d <= 0)
            return;

        d = d % n;
        RReverse(arr, n - d, n - 1);
        RReverse(arr, 0, n - d - 1);
        RReverse(arr, 0, n - 1);
    }

    public static void RReverse(int arr[], int start, int end) {
        while (start < end) {
            arr[start] = arr[start] + arr[end];
            arr[end] = arr[start] - arr[end];
            arr[start] = arr[start] - arr[end];
            start++;
            end--;
        }
    }

    /*
     * Otherwise we can use the following method to rotate the array
     * create a temp array of size d
     * copy the first d elements of arr to temp
     * copy the rest of the elements of arr to arr
     * copy the elements of temp to arr starting from the end of arr \
     * 
     */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int d = 2;
        System.out.println("Before Left Rotation:");
        printArray(arr);
        System.out.println();
        System.out.println("After Left Rotation:");
        lr(arr, d);
        printArray(arr);

        int arr1[] = { 1, 2, 3, 4, 5 };
        System.out.println();
        System.out.println("Before Right Rotation:");
        printArray(arr1);
        System.out.println();
        System.out.println("After Right Rotation:");
        rr(arr1, d);
        printArray(arr1);

    }

}
