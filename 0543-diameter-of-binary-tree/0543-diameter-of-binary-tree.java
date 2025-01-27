class Solution {
    private int result = 0; // Declare a class-level variable to store the diameter

    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return result;
    }

    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate the heights of the left and right subtrees
        int left = solve(root.left);
        int right = solve(root.right);

        // Update the global diameter (result)
        result = Math.max(result, left + right);

        // Return the height of the current node
        return Math.max(left, right) + 1;
    }
}
