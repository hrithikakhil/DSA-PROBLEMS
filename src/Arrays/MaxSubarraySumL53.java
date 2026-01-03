package Arrays;

public class MaxSubarraySumL53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            for(int i=0; i<n; i++){
                sum+=nums[i];
                maxSum = Math.max(maxSum, sum);
                if(sum<=0){
                    sum=0;
                }
            }
            return maxSum;
        }
    }
}

/* kadanes Algo
At every index:
-->Either extend the previous subarray
-->Or start a new subarray from this element
-->If the previous sum becomes negative, drop it — it only hurts future sums.
*/
