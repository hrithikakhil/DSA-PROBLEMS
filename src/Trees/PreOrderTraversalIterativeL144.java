package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    TreeNode treeNode;
    int task;

    Pair(TreeNode treeNode){
        this.treeNode = treeNode;
        this.task = 1;
    }
}

public class PreOrderTraversalIterativeL144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<Pair> st = new Stack<>();
        Pair rootP = new Pair(root);
        st.push(rootP);

        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.task==2){
                top.task++;
                if(top.treeNode.left!=null){
                    st.push(new Pair(top.treeNode.left));
                }
            }else if(top.task==1){
                ans.add(top.treeNode.val);
                top.task++;
            }else if(top.task==3){
                top.task++;
                if(top.treeNode.right!=null){
                    st.push(new Pair(top.treeNode.right));
                }
            }else{
                st.pop();
            }
        }
        return ans;
    }
}
