class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> b[1] - a[1]);
        int m = queries.length;
        int ans[] = new int[m];
        for (int i = 0; i < queries.length; i++) {
            int max = 0;
            for (int j = 0; j < items.length; j++) {
                if (items[j][0] <= queries[i]) {
                    max = items[j][1];
                    break;
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}