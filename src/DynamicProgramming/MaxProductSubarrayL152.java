package DynamicProgramming;

public class MaxProductSubarrayL152 {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int preffix = 1, suffix = 1;
        for(int i=0; i<n; i++){
            if(preffix==0){
                preffix = 1;
            }

            if(suffix==0){
                suffix = 1;
            }

            preffix = nums[i]*preffix;
            suffix = nums[n-i-1]*suffix;
            ans = Math.max(ans, Math.max(preffix, suffix));
        }

        return ans;
    }
}
