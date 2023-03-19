class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    
        return buildtree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildtree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
   
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
       
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
     
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        
     
        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;

        root.left = buildtree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildtree(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);
        
        return root;
    }
}
