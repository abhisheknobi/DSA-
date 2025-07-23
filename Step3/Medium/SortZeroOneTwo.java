package Step3.Medium;

public class SortZeroOneTwo {
//Dutch National Flag Problem

/*
 * Here the catch is that all the elements from start to low-1 are 0,
 * all the elements from low to mid-1 are 1,
 * all the elemnents from mid to high-1 are unsorted that is it can consist 1, 2 or 0
 * which is the initial state of the array.
 * all the elements from high to n-1 are 2.
 * we check the element using mid pointer and do the following:
 * if it is 0, we swap it with low pointer and increment both low and mid
 * if it is 1, we just increment mid
 * if it is 2, we swap it with high pointer and decrement high
 * we continue this process until mid pointer is less than or equal to high pointer.
 * 
 */
    public static int[] sort(int arr[]){
        int n=arr.length;
        int low=0;int mid=0;
        int high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1)
            mid++;
            else if(arr[mid]==2){
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        System.out.println("Before Sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        sort(arr);
        System.out.println("\nAfter Sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
