package Step3.Easy;

public class Largest {
    static int largest(int arr[]){
        int n=arr.length;
        int l=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>l){
                l=arr[i];
            }
        }
        return l;
    }

    static int  secondLargest(int arr[]){
        int n=arr.length;
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }else if(arr[i]>secondLargest && arr[i]!=largest){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int arr[]={5, 2, 8, 1, 9};
        System.out.println("Before Finding Largest Element:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int largestElement = largest(arr);
        int secondLargestElement = secondLargest(arr);
        System.out.println("Largest Element: " + largestElement);
        System.out.println("Second Largest Element: " + secondLargestElement);

    }
    
}
