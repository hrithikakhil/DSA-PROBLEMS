package SlidingWindow;

import java.util.HashMap;

public class SubarrayswithKDifferentIntegers_992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getCounts(nums, k) - getCounts(nums, k-1);
    }

    public int getCounts(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int l=0, r=0;
        int ans = 0;

        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size()>k){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }

            ans += r-l+1;
            r++;
        }

        return ans;
    }
}

/*
Observation 1: Why Does "Exactly K" Fail?
Array: [1, 0, 1, 0, 1], goal = 2
        ↑        ↑
        L        R
sum = 2 (exactly what we want!)
Now what?
- Expand R? sum becomes 2 again (still valid!)
- Contract L? sum becomes 1 (invalid!)
- We don't know the "direction" to move

Key Insight: The problem is that sum = goal doesn't tell us whether to expand or shrink. The decision is ambiguous.
 */

/*
Observation 2: What Makes Sliding Window Easy?
Example A: "Longest subarray with sum ≤ K"
- If sum ≤ K → EXPAND (we want longer)
- If sum > K → SHRINK (we must reduce)

Example B: "Shortest subarray with sum ≥ K"
- If sum < K → EXPAND (not there yet)
- If sum ≥ K → SHRINK (try to minimize)

Pattern Recognition: Sliding window works well when you have an inequality condition (≤, ≥, <, >), not an equality (=).

Why? Because:
Inequality gives direction: Too big? Shrink. Too small? Expand.
Equality gives ambiguity: Just right? Now what? 🤷

Transformation Strategy: Takeaway: Transform equality problems into inequality problems.
Can't solve "exactly K" → Try "at most K" instead!
 */

/*
Observation 3: "At Most K" Counts Too Many
The Realisation:
atMost(K) = {sum 0, sum 1, sum 2, ..., sum K}
exactly(K) = {sum K only}

Problem: atMost(K) includes extras! {0, 1, 2, ..., K-1}

Set Theory View:
atMost(2) = {0, 1, 2} ← includes extras
exactly(2) = {2} ← what we want
Extras = {0, 1} ← need to remove these!

Question: How do we represent "extras"?
Extras = {0, 1, 2, ..., K-1}
       = atMost(K-1)  ← Aha! 💡

Takeaway: The "extras" are exactly atMost(K-1).
 */

/*
Observation 4: Subtract to Isolate
Mathematical Proof:
atMost(K) = count(sum=0) + count(sum=1) + ... + count(sum=K)
atMost(K-1) = count(sum=0) + count(sum=1) + ... + count(sum=K-1)

Subtract:
atMost(K) - atMost(K-1) = count(sum=K) ✓

Why K-1 specifically?
✗ atMost(K-2): Leaves {K-1, K} (too much!)
✗ atMost(K):   Leaves {nothing} (too little!)
✓ atMost(K-1): Leaves {K} (perfect!)

Takeaway: K-1 is the precise boundary to isolate exactly K.
 */
