package SlidingWindow.VariableSizeWindowPattern;

public class MaxConsecutiveOnesIII_1004 {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int zeroscount = 0;

        int l=0, r=0, len=0;

        while(r<n){
            if(nums[r]==0){
                zeroscount++;
            }

            if(zeroscount<=k){
                len = Math.max(len, r-l+1);
            }

            while(zeroscount>k){
                if(nums[l]==0){
                    zeroscount--;
                }
                l++;
            }

            r++;
        }

        return len;
    }
}

/*
variable-size sliding window problem - "Expand until Invalid, Shrink until Valid" pattern!
expanding until zeros count > k and shrink until zeros count < k
*/