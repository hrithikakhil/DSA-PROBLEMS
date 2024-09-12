package Trees;

public class SearchInBSTL700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }

        if(root.val>val){
            return searchBST(root.left, val);
        }if(root.val<val){
            return searchBST(root.right, val);
        }else{
            return root;
        }
    }
}
