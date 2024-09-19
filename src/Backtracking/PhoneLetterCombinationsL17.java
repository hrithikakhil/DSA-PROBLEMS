package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombinationsL17 {
    String letters[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        StringBuilder str = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        if(n==0){
            return ans;
        }
        helper(digits, 0, ans, str);
        return ans;
    }

    public void helper(String digits, int idx, ArrayList<String> ans, StringBuilder temp){

        if(idx==digits.length()){
            ans.add(temp.toString());
            return;
        }

        int digit = digits.charAt(idx)-'0';

        for(int i=0; i<letters[digit].length(); i++){
            temp.append(letters[digit].charAt(i));
            helper(digits, idx+1, ans, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
