package trees;


import apple.laf.JRSUIUtils;

public class BuildBSTFromPreorder {
    public static void main(String[] args){
        int[] preorder = {8,5,1,7,10,12};
        bstFromPreorder(preorder);
        printTree(root);
    }

    static TreeNode root = null;
    public static void bstFromPreorder(int[] preorder) {

        for(int x : preorder){
            //root = buildBST(root,x);
            root = buildBSTOptimized(root,x);
        }
    }

    /**
     *
     * @param root
     * @param ele
     * @return root for the tree
     *
     * This solution has time complexity O(N^2) as it is traversing
     * the tree every time when we make a call to insert a new element
     */
    public static TreeNode buildBST(TreeNode root,int ele){
        if(root == null)
            return new TreeNode(ele,null,null);
        if(ele<root.val) {
            TreeNode left = buildBST(root.left, ele);
            root.left = left;
        }
        else {
            TreeNode right = buildBST(root.right, ele);
            root.right = right;
        }
        return root;
    }

    public static TreeNode buildBSTOptimized(TreeNode root, int ele){
        return root;
    }

    public static void  printTree(TreeNode root){
        if(root == null)
            return;
        printTree(root.left);
        System.out.print(root.val+" ");
        printTree(root.right);
    }
}


