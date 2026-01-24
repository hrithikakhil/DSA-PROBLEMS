package SlidingWindow;

public class AlternatingGroupsII_3208 {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        int n = colors.length;

        int left = 0;
        int count = 0;

        //Extend the array by first k-1 elements [For circular array or wrap around logic]
        for(int right = 0; right<n+k-1; right++){
            int curr = colors[right % n];
            int next = colors[(right+1) % n];

            if(curr==next){
                left=right; //breaking the alternating sequence.
            }

            if(right-left>=k-1){ //right-left is number of consecutive alternating pairs
                count++;
            }
        }

        return count;
    }
}
/*
INTUITION:
- Instead of checking each window separately, track the length of current alternating sequence
- Use two pointers: 'left' (start of alternating sequence) and 'right' (current position)
- 'right - left' gives the number of consecutive alternating pairs

Ex - [1 0 1] and k = 3
In the above example we have 2 pairs in the window size of k i.e for every window of size k we will have k-1 valid pairs/groups
*/