package SlidingWindow.FixedWindowPattern;

public class GrumpyBookstoreOwner_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = customers.length;
        int nonGrumpyCustomers = 0;
        int grumpyCustomers = 0;
        for(int i=0; i<minutes; i++){

            if(grumpy[i]==0){
                nonGrumpyCustomers += customers[i];
            }else{
                grumpyCustomers += customers[i];
            }
        }
        int maxGrumpyFromWindow = grumpyCustomers;
        int start = 0, end = minutes;
        while(end<n){
            if(grumpy[start]==1){
                grumpyCustomers -= customers[start];
            }

            if(grumpy[end]==0){
                nonGrumpyCustomers += customers[end];
            }

            if(grumpy[end]==1){
                grumpyCustomers += customers[end];
            }

            maxGrumpyFromWindow = Math.max(maxGrumpyFromWindow, grumpyCustomers);
            start++;
            end++;
        }

        return maxGrumpyFromWindow+nonGrumpyCustomers;
    }
}

/*
PROBLEM: Owner grumpy at certain minutes (grumpy[i]=1). Has ONE-TIME technique
to stay calm for 'minutes' consecutive minutes. Maximize satisfied customers.

EXAMPLE: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3

INTUITION 1 (Conceptual):
Find window with MOST total customers, force owner calm in that window.
- Best window [5,6,7]: 1+7+5 = 13
- Outside non-grumpy [0,2,4]: 1+1+1 = 3
- Total = 13 + 3 = 16 ✓

INTUITION 2 (Optimized):
Calculate baseline (grumpy=0), then find window that RESCUES most (grumpy=1).
- Baseline [0,2,4,6]: 1+1+1+7 = 10
- Best rescue window [5,6,7] rescues [5,7]: 1+5 = 6
- Total = 10 + 6 = 16 ✓

IMPLEMENTATION:
Sliding window tracks max grumpy customers to rescue.
Simultaneously accumulates all non-grumpy customers.
Combines both approaches in one pass!

TIME: O(n) | SPACE: O(1)
*/