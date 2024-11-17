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
        List<String> str = new ArrayList<>();
        helper(root, "", str);
        return str;        
    }

    public void helper(TreeNode root, String path, List<String> str) {
        if(root == null) {
            return;
        }
        path += root.val;
        
        if(root.left == null && root.right == null) {
            str.add(path);
        }else {
            path += "->";
            helper(root.left, path, str);
            helper(root.right, path, str);
        }
    }
}