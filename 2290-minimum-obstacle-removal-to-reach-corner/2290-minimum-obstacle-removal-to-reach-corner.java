class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


        q.add(new int[]{0, 0});
        
        int[][] dist = new int[m][n];
        for (int[] row: dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        while (!q.isEmpty()) {
            

            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int newrow = curr[0] + dir[i][0];
                int newcol = curr[1] + dir[i][1];


                if (newrow < 0 || newcol < 0 || newrow >= grid.length || newcol >= grid[0].length) {
                    // skipped while:
                    // out of bound
                    continue; 
                }


                if (grid[newrow][newcol] == 1) {
                    if (dist[curr[0]][curr[1]] + 1 < dist[newrow][newcol]) {
                        dist[newrow][newcol] = dist[curr[0]][curr[1]] + 1;
                        q.add(new int[]{newrow, newcol});
                    }
                } else if (grid[newrow][newcol] == 0) {
                    if (dist[curr[0]][curr[1]] < dist[newrow][newcol]) {
                        dist[newrow][newcol] = dist[curr[0]][curr[1]];
                        q.add(new int[]{newrow, newcol});
                    }
                } 
            }

        }
        return dist[m - 1][n - 1];
    }
}