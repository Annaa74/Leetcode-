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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        
        while (i < traversal.length()) {
            int level = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                level++;
                i++;
            }
            
            int value = 0;
            while (i < traversal.length() && traversal.charAt(i) != '-') {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            
            TreeNode node = new TreeNode(value);
            
            if (level == stack.size()) {
                if (!stack.isEmpty()) {
                    stack.peek().left = node;
                }
            } else {
                while (level != stack.size()) {
                    stack.pop();
                }
                stack.peek().right = node;
            }
            
            stack.push(node);
        }
        
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.pop();
    }
}
