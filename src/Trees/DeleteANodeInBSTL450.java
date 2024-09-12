package Trees;

public class DeleteANodeInBSTL450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }

        if(root.val>key){
            root.left = deleteNode(root.left, key);
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.right==null && root.left==null){
                return null;
            }else if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }else{
                TreeNode min = find_Min_Node(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }

        return root;
    }

    public TreeNode find_Min_Node(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}
