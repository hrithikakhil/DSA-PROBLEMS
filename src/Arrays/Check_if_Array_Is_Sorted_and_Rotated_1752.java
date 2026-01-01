package Arrays;

/*
Problem - 1752. Check if Array Is Sorted and Rotated
Level - Easy
URL - https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 */
public class Check_if_Array_Is_Sorted_and_Rotated_1752 {

    public boolean check(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return true;
        }
        int count = 0;
        for(int i=1; i<n; i++){
            if(nums[i-1]>nums[i]){
                count++;
            }
        }
        if(nums[n-1]>nums[0]){
            count++;
        }
        return (count<=1)?true:false;
    }
}

//Idea - The sorted and roatated array will always have a single break point or no break point, so if there are multiple break points return false or true
//TC - 0(N)
//SC - 0(1)