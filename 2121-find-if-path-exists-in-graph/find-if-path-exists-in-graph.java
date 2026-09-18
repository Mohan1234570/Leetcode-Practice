class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        vis[source] = true;

        while(!q.isEmpty()){
           int node = q.poll();
           if(node == destination ){
                return true;
            }
           for(int neighber : graph.get(node)){

              if(!vis[neighber]){
                vis[neighber] = true;
                q.offer(neighber);
              }
           }
        }

        return false;
    }
}