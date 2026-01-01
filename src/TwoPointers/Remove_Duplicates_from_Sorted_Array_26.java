package TwoPointers;

/* Remove Duplicates from Sorted Array
Problem: Remove duplicates in-place from sorted array, return count of unique elements

Approach: Two-pointer technique
i = position of last unique element (slow pointer)
j = scanner to find next unique element (fast pointer)

Algorithm:
1. Start: i=0, j=1
2. If nums[i] == nums[j] -> duplicate found, move j++
3. If nums[i] != nums[j] -> new unique found:
    - Place at nums[i+1] = nums[j]
    - Move both: i++, j++
4. Return i+1 (count of unique elements)

Key Idea: Since array is sorted, duplicates are adjacent.
          Build unique array in first k positions while scanning.
Complexity: Time O(n), Space O(1)
Example: [1,1,2,2,3] -> [1,2,3,_,_] -> return 3
*/
public class Remove_Duplicates_from_Sorted_Array_26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0, j=1;
        while(j<n){
            if(nums[i]==nums[j]){
                j++;
            }else{
                nums[i+1]=nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
//Approach 2 : Two-pointer technique (Slightly Different)
// - idx = position where next unique element should be placed (starts at 0)
// - j = scanner that moves through array (starts at 1)
    public int removeDuplicates1(int[] nums) {

        // Use Two Pointers Approach
        int n = nums.length;
        int idx = 0; // Using this pointer to keep only unique nums in this index;
        int j = 1;
        while(j<n){
            if(nums[j]!=nums[j-1]){
                idx++;
                nums[idx] = nums[j];
            }
            j++;
        }

        return idx+1;
    }
}
