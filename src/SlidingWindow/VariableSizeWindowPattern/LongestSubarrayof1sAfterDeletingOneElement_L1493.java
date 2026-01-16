package SlidingWindow.VariableSizeWindowPattern;


public class LongestSubarrayof1sAfterDeletingOneElement_L1493 {
    public int longestSubarray(int[] nums) {

        int n = nums.length;

        int countzeros = 0;
        int maxlen = 0;
        int l = 0, r = 0;
        while(r<n){
            if(nums[r]==0){
                countzeros++;
            }

            while(countzeros>1){
                if(nums[l]==0){
                    countzeros--;
                }
                l++;
            }

            maxlen = Math.max(maxlen, r-l);

            r++;
        }

        return maxlen;
    }
}

/*
Intuition:
Variable-size sliding window problem - "Expand until Invalid, Shrink until Valid" pattern!
- Expand window: include nums[r]
- Window is INVALID when: countzeros > 1
- Shrink window until VALID: countzeros <= 1
- Answer: r - l (not r - l + 1) because we MUST delete exactly one element

This is the same as 1004. Max Consecutive Ones III with k=1, but:
- In 1004: we return the full window size (r - l + 1) because we flip k zeros
- In 1493: we return (r - l) because we DELETE one element (not flip)

Key insight:
- r - l + 1 = window size
- r - l = window size - 1 (accounts for the mandatory deletion)
*/