package trees;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    /**
     * Prints prreorder traversal of the tree
     * @param root
     */
     void printTree(TreeNode root){
        if(root == null)    return;
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }


     TreeNode invertTree(TreeNode root){
        if(root == null)    return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[] args){
        int arr[] = {4,2,7,1,3,6,9};
        TreeNode root = new TreeNode(4,null,null);
        root.left = new TreeNode(2,null,null);
        root.left.left = new TreeNode(1,null,null);
        root.left.right = new TreeNode(3,null,null);
        root.right = new TreeNode(7,null,null);
        root.right.left = new TreeNode(6,null,null);
        root.right.right = new TreeNode(9,null,null);
        InvertBinaryTree obj = new InvertBinaryTree();
        obj.printTree(root);
        root = obj.invertTree(root);
        System.out.println("\nInverted binary tree preorder traversal :");
        obj.printTree(root);
    }
}
