package SlidingWindow;

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

        for (int i = k; i < numslen; i++) {
            currSum -= nums[i - k];
            if (freqMap.get(nums[i - k]) == 1) {
                freqMap.remove(nums[i - k]);
            } else {
                freqMap.put(nums[i - k], freqMap.get(nums[i - k]) - 1);
            }

            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            currSum += nums[i];

            if (freqMap.size() == k) {
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }
}