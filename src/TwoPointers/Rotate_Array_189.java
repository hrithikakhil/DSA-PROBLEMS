package TwoPointers;

//Question - Rotate Array - 189
//URL - https://leetcode.com/problems/rotate-array/
//Idea - Just use reverse logic
//Step 1 - Reverse the entire array first
//Step 2 - Reverse the first k elements
//Step 3 - Now Reverse the remaining elements [k to n-1]
//Imp - Edge Case - When k is bigger than arr length, using % reduce the K to less than arr length
//Your k %= arr.length correctly handles when k > n (e.g., rotating by 10 in an array of 7 is same as rotating by 3)
//It also handles k = 0 and k = n (no rotation needed)
public class Rotate_Array_189 {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k%=arr.length;

        reverseInRange(0, n-1, arr);
        reverseInRange(0, k-1, arr);
        reverseInRange(k, n-1, arr);
    }

    public int[] reverseInRange(int start, int end, int[] arr){

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }
}
