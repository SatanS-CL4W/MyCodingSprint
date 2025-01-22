class Solution {
    public int minCut(String s) {
        int n = s.length();

        Integer[][] dp = new Integer[n][n];

        int res = helper(s, 0, n - 1, dp);

        return res;
    }

    int helper(String s, int i, int j, Integer[][] dp) {
         if(dp[i][j] != null) {
            return dp[i][j];
        }

        if(i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        int minVal = Integer.MAX_VALUE;

        for(int k = i; k <= j - 1; k++) {

            int cost = helper(s, i, k, dp)
                     + helper(s, k + 1, j, dp)
                     + 1;

            minVal = Math.min(minVal, cost);
        }

        dp[i][j] = minVal;
        return dp[i][j];
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    
}