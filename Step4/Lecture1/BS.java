package Step4.Lecture1;

public class BS {
    public static int iterative(int[] arr, int target) {
        int low = 0;
        int n = arr.length;
        int mid = 0;
        int high = n - 1;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int recursive(int[] arr, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) / 2);
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return recursive(arr, mid + 1, high, target);
        else
            return recursive(arr, low, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 5;
        int target2 = 10;
        System.out.println("Iterative Binary Search: " + iterative(arr, target));
        System.out.println("Recursive Binary Search: " + recursive(arr, 0, arr.length - 1, target2));
    }

}
