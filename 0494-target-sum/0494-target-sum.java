class Solution {
    // Let sum of subset 1 be s1 and subset 2 with s2
    // s1 - s2 = diff (given)
    // s1 + s2 = sum of array (logical)
    // Therefore adding both equations we get:
    // 2 * s1 = diff + sum of array
    // s1 = (diff + sum of array) / 2;
    // Problem reduces to finding the number of subsets with the given sum
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int x: nums) {
            sum += x;
        }
        
        if((sum + target) % 2 != 0) {
            return 0;
        }
        int reqSum = (sum + target) / 2;
        if(reqSum < 0) {
            return 0;
        }
        
        int[][] dp = new int[n + 1][reqSum + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= reqSum; j++) {
                if(nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    
    return dp[n][reqSum];
    }
}