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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, new StringBuilder(), result);
        return result;
    }

    private void helper(TreeNode root, StringBuilder path, List<String> result) {
        int length = path.length();
        path.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            if (root.left != null) helper(root.left, path, result);
            if (root.right != null) helper(root.right, path, result);
        }

        path.setLength(length);
    }
}
