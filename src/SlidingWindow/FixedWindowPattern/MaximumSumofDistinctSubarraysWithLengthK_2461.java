package SlidingWindow.FixedWindowPattern;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumofDistinctSubarraysWithLengthK_2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        int numslen = nums.length;
        long currSum = 0, maxSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            currSum += nums[i];
        }

        if (freqMap.size() == k) {
            maxSum = Math.max(currSum, maxSum);
        }

        int start = 0, end = k;
        while(end<numslen){
            currSum = currSum - nums[start] + nums[end];

            int count = freqMap.get(nums[start]);
            if(count == 1){
                freqMap.remove(nums[start]);
            }else{
                freqMap.put(nums[start], count - 1);
            }

            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);

            if (freqMap.size() == k) {
                maxSum = Math.max(currSum, maxSum);
            }
            start++;
            end++;
        }
        return maxSum;
    }
}

/*
Fixed Size Window Patterns - This is nothing but finding the sum of subarray size K, but with condition that all elements hould be unique in the subarray...
Now how do u check the duplicates/Unique - Hashing
Simple move the window accordingly - if the left most ele is still in the Hashmap remove the ele if count is 1 or reduce the count otherwise
Now add the rightmost element to the HM and check the size if it equals k then calculate max answer so far
*/