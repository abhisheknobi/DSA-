package Step3_Arrays.Easy;

public class FindSingle {
    public static int find(int arr[]) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4 };

        System.out.println(find(nums));
    }

}
