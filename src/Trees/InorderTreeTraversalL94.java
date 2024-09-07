package Trees;

import java.util.ArrayList;
import java.util.List;



public class InorderTreeTraversalL94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalImpl(root, list);
        return list;
    }

    public void inorderTraversalImpl(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }

        inorderTraversalImpl(root.left, list);
        list.add(root.val);
        inorderTraversalImpl(root.right, list);
    }

}
