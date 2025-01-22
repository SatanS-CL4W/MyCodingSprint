import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    isWater[i][j] = 0;
                } else {
                    isWater[i][j] = -1;
                }
            }
        }
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0], y = current[1];
            
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && isWater[nx][ny] == -1) {
                    isWater[nx][ny] = isWater[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return isWater;
    }
}