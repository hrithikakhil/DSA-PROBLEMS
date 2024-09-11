package Trees;

public class MaxDepthOfBinaryTreeL104 {
    int depth = 0;
    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        depth = Math.max(leftDepth, rightDepth) + 1;
        return depth;
    }
}
