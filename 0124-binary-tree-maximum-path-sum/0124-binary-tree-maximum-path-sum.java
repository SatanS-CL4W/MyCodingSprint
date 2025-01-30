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
    public int maxPathSum(TreeNode root) {
        int[] pathsum = new int[1];
        pathsum[0] = Integer.MIN_VALUE;
        maxSum(root, pathsum);

        return pathsum[0];
    }

    public int maxSum(TreeNode root, int[] path) {
        if(root == null) {
            return 0;
        }

        int left = maxSum(root.left, path);
        int right = maxSum(root.right, path);

        int temp = Math.max(Math.max(left, right) + root.val, root.val);
        int ans = Math.max(temp, left + right + root.val);
        path[0] = Math.max(ans, path[0]);

        return temp;
    }
}