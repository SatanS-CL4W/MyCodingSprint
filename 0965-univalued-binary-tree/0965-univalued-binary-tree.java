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
    public boolean isUnivalTree(TreeNode root) {
        int key = root.val;
        
        return helperDFS(root, key);
    }

    public boolean helperDFS(TreeNode root, int key) {
        if(root == null ) {
            return true;
        }
        if(root.val != key) {
            return false;
        }

        return helperDFS(root.left, key) && helperDFS(root.right, key);
    }
}