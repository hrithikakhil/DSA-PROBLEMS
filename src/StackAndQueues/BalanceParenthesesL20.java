package StackAndQueues;

import java.util.Stack;

public class BalanceParenthesesL20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }else if(st.peek()=='(' && ch==')'){
                    st.pop();
                }else if(st.peek()=='{' && ch=='}'){
                    st.pop();
                }else if(st.peek()=='[' && ch==']'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        // if(st.isEmpty()){
        //     return true;
        // }
        // return false;
        return st.isEmpty();
    }
}
