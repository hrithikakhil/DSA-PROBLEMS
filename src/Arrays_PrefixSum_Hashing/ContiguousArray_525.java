package Arrays_PrefixSum_Hashing;
import java.util.HashMap;
/*
calculate the sum as follows. if you find a 1 add 1 to the sum; if you find 0 substract 1 from the sum.
nums = [1,1,0,0,1,1,0,1,1]
sum = [1,2,1,0,1,2,1,2,3]
Observe it carefully. If you find a sum which you have already found. you actually have a subarr with equal number of 0's and 1's. For example. in the sum array you have 2 as the sum in index 1. you found the sum 2 again in index 5. see the elements of nums from index 1+1 to 5 you have equal number of 0's and 1's. Write that down in a paper and pen and you can observe it easily. One more edge case is , what if you have a sum as 0. You can easily figure it out...
*/


public class ContiguousArray_525 {
    public int findMaxLength(int[] nums) {

        int n = nums.length;
        int maxlen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<n; i++){
            // So the basic idea here is to add 1 when u see 1, and sub by 1 when 0 is found.
            // Now whenever you find the sum in the hashmap, it suggests that the elements btw them have eqaul 0's == 1's
            if(nums[i]==0){
                sum+= -1;
            }else{
                sum+=1;
            }

            if(sum==0){
                maxlen = Math.max(maxlen, i+1);
            }

            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                maxlen = Math.max(maxlen, len);
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return maxlen;
    }
}

