package Arrays_PrefixSum;

public class PivotIndex724 {
/*Idea -
At any index i, if it's a pivot:
Left sum = sum of all elements before i
Right sum = sum of all elements after i
1  7  3  6  5  6
1  8  11 17 22 28
28 27 20 17 11 6
If u observe at any index totalSum would be
totalSum = leftSum + nums[i] + rightSum
Now rearrange leftSum = totalSum-nums[i]-rightSum
*/
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0, leftSum=0;

        for(int i=0; i<n; i++){
            totalSum+=nums[i];
        }

        for(int i=0; i<n; i++){
            if(leftSum==totalSum-nums[i]-leftSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
/*Idea - Create Two Prefix arrays - right and left
If pivot index exists - the prefix sum values of both array at index i will be same
TC - O(N)
SC - O(N)
*/

    public int pivotIndex1(int[] nums) {
        int n = nums.length;
        int rightSumArr[] = new int[n];

        rightSumArr[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            rightSumArr[i] = nums[i]+rightSumArr[i+1];
        }

        for(int i=1; i<n; i++){
            nums[i]+=nums[i-1];
        }

        for(int i=0; i<n; i++){
            if(nums[i]==rightSumArr[i]){
                return i;
            }
        }
        return -1;
    }
}
