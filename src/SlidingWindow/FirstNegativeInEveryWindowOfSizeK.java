package SlidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {

    public long[] printFirstNegativeInteger(long A[], int N, int K){
        Queue<Long> q = new LinkedList<>();

        long[] ans = new long[N-K+1];

        for(int i=0; i<K; i++){
            if(A[i]<0){
                q.add(A[i]);
            }
        }

        int idx = 0;
        if(q.isEmpty()){
            ans[idx++]=0;
        }else{
            ans[idx++] = q.peek();
        }

        int i=1;
        int j=K;
        while(j<N){
            if(!q.isEmpty() && q.peek()==A[i-1]){
                q.remove();
            }

            if(A[j]<0){
                q.add(A[j]);
            }

            if(q.isEmpty()){
                ans[idx++]=0;
            }else{
                ans[idx++] = q.peek();
            }
            i++;
            j++;
        }
        return ans;
    }
}
