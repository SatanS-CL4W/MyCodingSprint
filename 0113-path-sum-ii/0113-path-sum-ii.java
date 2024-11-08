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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        helperDFS(root, targetSum, res, arr);  

        return res;
    }

    public void helperDFS(TreeNode root, int sum, List<List<Integer>> res, List<Integer> arr) {
        if(root == null) {
            return;
        }
        arr.add(root.val); //Adding root value
         
        if(root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(arr));
        }else {
            helperDFS(root.left, sum - root.val, res, arr);
            helperDFS(root.right, sum - root.val, res, arr);
        }

        arr.remove(arr.size() - 1); //Backtracking the last value
    }
}