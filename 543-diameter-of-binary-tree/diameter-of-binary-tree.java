/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       
        height(root);
        return diameter;
    }

    private int height(TreeNode Node) {
        if (Node == null) {
            return 0;
        }
        int leftHeight = height(Node.left);
        int rightHeight = height(Node.right);

 
        diameter = Math.max(diameter,  leftHeight + rightHeight);

    
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

