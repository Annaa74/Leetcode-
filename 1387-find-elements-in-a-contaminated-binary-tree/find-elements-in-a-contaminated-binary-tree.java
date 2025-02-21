import java.util.HashSet;
import java.util.Set;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class FindElements {
    private Set<Integer> recovered;

    public FindElements(TreeNode root) {
        recovered = new HashSet<>();
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int val) {
        if (node != null) {
            node.val = val;
            recovered.add(val);
            recoverTree(node.left, 2 * val + 1);
            recoverTree(node.right, 2 * val + 2);
        }
    }

    public boolean find(int target) {
        return recovered.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
