class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        int lcs = helper(text1, text2, n, m, dp);

        return lcs;
    }

    public int helper(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + helper(s1, s2, n - 1, m - 1, dp);
        }else {
            dp[n][m] = Math.max(helper(s1, s2, n - 1, m, dp), helper(s1, s2, n, m - 1, dp));
        }

        return dp[n][m];
    }
}