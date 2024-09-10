package Trees;

import java.util.HashMap;

public class CreateTreeFromPreorderAndInorderArrayL105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;
        int m = inorder.length;

        for(int i=0; i<m; i++){
            map.put(inorder[i], i);
        }

        return createTree(0, n-1, 0, m-1, preorder, inorder, map);
    }

    public TreeNode createTree(int ps, int pe, int is, int ie, int[] preorder, int[] inorder, HashMap<Integer, Integer> map){
        if(ps>pe || is>ie){
            return null;
        }

        int rootData = preorder[ps];
        TreeNode root = new TreeNode(rootData);
        int rootIdx = map.get(rootData);
        int eleLST = rootIdx - is;  // (is to rootIdx-1) => rootIdx - 1 - is + 1 => rootIdx -is
                                        // (ps+1 to e) = eleLST => e - ps - 1 + 1 = eleLST => eleLST+ps
        root.left = createTree(ps+1, eleLST+ps, is, rootIdx-1, preorder, inorder, map);
        root.right = createTree(eleLST+ps+1, pe, rootIdx+1, ie, preorder, inorder, map);

        return root;
    }
}
