package Arrays;

public class NextPermutationL31 {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step - 1 Find the break point.
        int break_idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break_idx = i;
                break;
            }
        }

        // If no breaking point reverse the whole array and return
        if (break_idx == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        //Step 2 - Find the closest number which is greater than value at break_idx.
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[break_idx]) {
                int temp = nums[i];
                nums[i] = nums[break_idx];
                nums[break_idx] = temp;
                break;
            }
        }

        // Step 3 - Reverse the remaining array part i.e from break_idx+1 to n-1
        reverse(nums, break_idx+1, n-1);
    }

    public void reverse(int arr[], int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
