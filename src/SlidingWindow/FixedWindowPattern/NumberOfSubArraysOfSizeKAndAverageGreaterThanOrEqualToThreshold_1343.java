package SlidingWindow.FixedWindowPattern;

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;

        int sum = 0, ans = 0;
        for(int i=0; i<k; i++){
            sum+=arr[i];
        }

        if(sum>=(k*threshold)){
            ans++;
        }

        int start = 0, end = k;
        while(end<n){
            sum = sum - arr[start] + arr[end];
            if(sum>=(k*threshold)){
                ans++;
            }
            start++;
            end++;
        }

        return ans;
    }
}

/*
Fixed window pattern
You dont have to really calculate avg, just observe the arr size is fixed and theres threshold, basically
(sum_val)/arr_size >= threshold
rearrange => sum_val >= arr_size * threshold
now slide the window and check if the actual sum is greater than or equal to sum_val (from above equation)
*/
