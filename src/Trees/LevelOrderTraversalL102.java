package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalL102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode front = q.remove();
                ans.add(front.val);
                if(front.left!=null){
                    q.add(front.left);
                }

                if(front.right!=null){
                    q.add(front.right);
                }
            }
            list.add(ans);
        }

        return list;
    }
}
