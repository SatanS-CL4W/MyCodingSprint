class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        List<Integer>[] adj = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            adj[i].add(i + 1);
        }

        for (int i = 0; i < m; i++) {
            adj[queries[i][0]].add(queries[i][1]);

            ans[i] = calcMin(0, n - 1, adj);
        }
        
        return ans;
    }

    private int calcMin(int start, int end, List<Integer>[] adj) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, start}); 

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentNode = current[1];
            if (currentNode == end) {
                return currentDist;
            }

            for (int neighbor : adj[currentNode]) {
                int newDist = currentDist + 1; 
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.offer(new int[]{newDist, neighbor});
                }
            }
        }

        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }
}