package Arrays_PrefixSum_Hashing;

import java.util.HashMap;

/*
Idea - Prefix Sum + HashMap
If subarray [j+1 to i] sums to k, then:
prefixSum[i] - prefixSum[j] = k
→ prefixSum[j] = prefixSum[i] - k
At index i, if (currentSum - k) exists in map, we found a subarray with sum k.
Store frequency of each prefix sum to count all valid subarrays.
*/

public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int count=0, sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];

            if(sum==k){
                count++;
            }

            int x = sum-k;
            if(map.containsKey(x)){
                count+=map.get(x);
            }

            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }
        return count;
    }
}

/* Why 2 pointers doesnt work
Take an Example [3,4,7,-2,2,1,4,2] and k=7
It's solution using 2 ptr approach will be: 4
i.e. [3,4] , [7] , [7,-2,2] , [-2,2,1,4,2] , [1,4,2]
It's solution using presum based map:
[3,4] , [7] , [7,-2,2] , [-2,2,1,4,2], [2,1,4] , [1,4,2]
Basically we are unable to count [2,1,4] using 2 ptr approach.
Why so?
Because while using 2 pointer approach, our assumption is that no subset of the set under consideration can form an answer.
This would be true if we didn't had -ve numbers.
When we are on set [-2,2,1,4] we don't consider that their is a possibility that their might be an answer in this, and hence we acquire another 2 since sum here is less than k.
*/