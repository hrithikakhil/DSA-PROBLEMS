package Trees;

public class SumRootToLeafNumbersL129 {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return dfs(root, sum);
    }

    public int dfs(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        sum = sum*10 + root.val;
        if(root.left==null && root.right==null){
            return sum;
        }

        int leftSum = dfs(root.left, sum);
        int rightSum = dfs(root.right, sum);

        return leftSum+rightSum;
    }
}
