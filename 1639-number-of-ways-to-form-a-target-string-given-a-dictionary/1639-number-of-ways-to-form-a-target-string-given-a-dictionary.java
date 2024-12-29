class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1000000007;
        int targetLength = target.length();
        int wordLength = words[0].length();
        
        // Preprocess to count the number of each character at each position in words
        int[][] charCounts = new int[wordLength][26];
        for (String word : words) {
            for (int k = 0; k < wordLength; k++) {
                charCounts[k][word.charAt(k) - 'a']++;
            }
        }
        
        // DP table: dp[i][j] = number of ways to form target[0..i] using words[0..j]
        long[][] dp = new long[targetLength + 1][wordLength + 1];
        for (int j = 0; j <= wordLength; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i <= targetLength; i++) {
            for (int j = 1; j <= wordLength; j++) {
                dp[i][j] = dp[i][j - 1]; // Not using the j-th character
                char currentTargetChar = target.charAt(i - 1);
                dp[i][j] += dp[i - 1][j - 1] * charCounts[j - 1][currentTargetChar - 'a'];
                dp[i][j] %= MOD;
            }
        }
        
        return (int) dp[targetLength][wordLength];
    }
}