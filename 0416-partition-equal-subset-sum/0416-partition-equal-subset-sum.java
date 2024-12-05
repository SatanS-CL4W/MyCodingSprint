class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num: nums) {
            sum += num;
        }
        
        if(sum % 2 != 0) {
            return false;
        }else {
            int target = sum / 2;
            int n = nums.length;
            Boolean[][] dp = new Boolean[n + 1][target + 1];
            return subsetSum(nums, n, target, dp);
        }
    }

    public boolean subsetSum(int[] arr, int n, int target, Boolean[][] dp) {
        if(target == 0) {
            return true;
        }
        if(n <= 0) {
            return false;
        }

        if(dp[n][target] != null) {
            return dp[n][target];
        }

        if(arr[n-1] <= target) {
            dp[n][target] = subsetSum(arr, n-1, target, dp) || subsetSum(arr, n-1, target - arr[n-1], dp);
        }else {
            dp[n][target] = subsetSum(arr, n-1, target, dp);
        }

        return dp[n][target];
    }
}