class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Prefix sums for the top and bottom rows
        long[] topPrefix = new long[n];
        long[] bottomPrefix = new long[n];

        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];

        for (int i = 1; i < n; i++) {
            topPrefix[i] = topPrefix[i - 1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        
        for (int i = 0; i < n; i++) {
            long topRemaining = i < n - 1 ? topPrefix[n - 1] - topPrefix[i] : 0;
            long bottomRemaining = i > 0 ? bottomPrefix[i - 1] : 0;
            long secondRobotScore = Math.max(topRemaining, bottomRemaining);

            
            result = Math.min(result, secondRobotScore);
        }

        return result;
    }
}