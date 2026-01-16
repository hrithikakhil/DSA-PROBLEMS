package SlidingWindow.FixedWindowPattern;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateII_L239 {

    /*
    Intuition: Check if there exists duplicates within a window of size k+1
    (k+1 because we need to check elements that are at most k distance apart)

    Solution: Use HashMap/HashSet with sliding window
    Edge case: When k >= n, window size = n (can't exceed array length)

    Time: O(n), Space: O(min(k, n))
    */

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int windowSize = Math.min(k + 1, n);

        for(int i=0; i<windowSize; i++){
            if(map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i], i);
            }
        }

        int start = 0, end = windowSize;

        while(end<n){
            map.remove(nums[start]);

            if(map.containsKey(nums[end])){
                return true;
            }else{
                map.put(nums[end], end);
            }

            start++;
            end++;
        }

        return false;
    }

    /*
    Intuition: Use HashSet as a sliding window of size ≤ k
    - Add current element to window
    - If window size > k, remove the element that's k+1 positions back
    - If we see a duplicate in the window, it's within distance k

    Why size > k, not size > k+1?
    - We want to maintain k elements AFTER adding the current one
    - So we remove when size exceeds k (meaning we have k+1 elements)
    */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            if(set.contains(nums[i])){
                return true; // Duplicate within window!
            }

            set.add(nums[i]);

            if(set.size() > k){  // Window size exceeds k+1
                set.remove(nums[i - k]);  // Remove oldest
            }
        }

        return false;
    }
}

