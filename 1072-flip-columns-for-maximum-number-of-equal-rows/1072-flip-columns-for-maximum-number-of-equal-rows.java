class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            for (int val : row) {
                pattern.append(val == row[0] ? '0' : '1');
            }
            patternCount.put(pattern.toString(), patternCount.getOrDefault(pattern.toString(), 0) + 1);
        }
        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }
        return maxRows;
    }
}

// Runtime: 18ms Beats 95.51%
// Memory: 58.52MB Beats 66.42%