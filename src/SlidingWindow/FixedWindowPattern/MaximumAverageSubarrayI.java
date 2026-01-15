package SlidingWindow.FixedWindowPattern;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        double ans = 0;
        double sum = 0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }

        ans = sum/k;

        int start = 0;
        int end = k;

        while(end<n){
            sum = sum - nums[start] + nums[end];

            ans = Math.max(ans, sum/k);
            start++;
            end++;
        }

        return ans;
    }
}

/*
Fixed Window Sliding Pattern
*/