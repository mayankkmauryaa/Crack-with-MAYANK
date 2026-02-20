/**
 * Definition for a binary tree root.
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
    List<Integer> nums;

    public TreeNode balanceBST(TreeNode root) {
        nums = new ArrayList<Integer>();
        order(root);
        return balanceTree(0, nums.size() - 1);
    }

    private void order(TreeNode root) {
        if (root == null) return;
        order(root.left);
        nums.add(root.val);
        order(root.right);
    }

    private TreeNode balanceTree(int l, int r) {
        if (l > r)
            return null;
        int mid = l + ((r - l) / 2);
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = balanceTree(l, mid - 1);
        root.right = balanceTree(mid + 1, r);
        return root;
    }
}