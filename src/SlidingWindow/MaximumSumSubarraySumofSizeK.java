package SlidingWindow;

import java.util.ArrayList;

public class MaximumSumSubarraySumofSizeK {

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){

        long maxSum = 0;
        long sum = 0;
        for(int i=0; i<K; i++){
            sum+=Arr.get(i);
        }

        maxSum = sum;

        int start = 1;
        int end = K;
        while(end<N){
            sum = sum - Arr.get(start-1) + Arr.get(end);
            maxSum = Math.max(maxSum, sum);
            start++;
            end++;
        }
        return maxSum;

    }
}
