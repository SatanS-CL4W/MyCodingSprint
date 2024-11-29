class Solution {
    public int minimumTime(int[][] grid) {
        
        if(grid[0][1]>=2 && grid[1][0]>=2) return -1;
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int n = grid.length,m=grid[0].length;
        boolean vis[][] = new boolean[n][m];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        q.add(new int[]{0,0,0});
        while(!q.isEmpty())
        {
            int[] cur = q.poll();
            int t = cur[0],r = cur[1],c = cur[2];
            if(r==n-1 && c==m-1) return t;
            if(vis[r][c]) continue;
            vis[r][c]=true;

            for(int[] i:dir)
            {
                int nr = r + i[0],nc = c + i[1];
                if(nr<0 || nr>=n || nc<0 || nc >=m || vis[nr][nc]) continue;
                int cycle = ((grid[nr][nc] - t) % 2 ==0) ? 1 : 0;
                q.add(new int[]{Math.max(grid[nr][nc]+cycle,t+1),nr,nc});
            }
        }
        return -1;
    }
}