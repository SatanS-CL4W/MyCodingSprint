class Solution {
    static class pair{
        int node;
        int dis;
        public pair(int node,int dis){
            this.node=node;
            this.dis=dis;
        }
    }
    public static int bfs(List<List<Integer>>adj,boolean visited[],int node){
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(node,0));
        int maxdis=0;
        visited[node]=true;
        while(!q.isEmpty()){
           pair top=q.poll();
           int currnode=top.node;
           int currdis=top.dis;
           for(int neighbour:adj.get(currnode)){
            if(!visited[neighbour]){
                visited[neighbour]=true;
                q.offer(new pair(neighbour,currdis+1));
                maxdis=Math.max(maxdis,currdis+1);
            }
           }
        }
    return maxdis;
    }
    public int maximumInvitations(int[] favorite) {
        List<List<Integer>>adj=new ArrayList<>();
        int n=favorite.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //making the reverse graph;
        for(int i=0;i<n;i++){
            int u=i;
            int v=favorite[i];
            adj.get(v).add(u);
        }
        int max_cycle_length=0;
        int happy_couple=0;
        boolean visited[]=new boolean[n];
        Arrays.fill(visited,false);
        for(int i=0;i<n;i++){
           if(!visited[i]){
            Map<Integer,Integer>map=new HashMap<>();
            int curr_node=i;
            int count_curr_node=0;
            while(!visited[curr_node]){
                visited[curr_node]=true;
                map.put(curr_node,count_curr_node);
                int next_node=favorite[curr_node];
                count_curr_node+=1;
                if(map.containsKey(next_node)){
                    int cycle_length=count_curr_node-map.get(next_node);
                    max_cycle_length=Math.max(max_cycle_length,cycle_length);
                    if(cycle_length==2){
                        boolean visited1[]=new boolean[n];
                        visited1[curr_node]=true;
                        visited1[next_node]=true;
                        happy_couple+=(2+bfs(adj,visited1,curr_node)+bfs(adj,visited1,next_node));
                    }
                    break;
                }
                curr_node=next_node;
            }
           }
        }
        return Math.max(max_cycle_length,happy_couple);
    }
}