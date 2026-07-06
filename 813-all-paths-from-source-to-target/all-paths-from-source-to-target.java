class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        al.add(0);
        path(graph,0,ans,al);
        return ans;
    }
    public void path(int[][] graph, int node, List<List<Integer>> ans, List<Integer> al){
      if(node == graph.length-1){
        ans.add(new ArrayList<>(al));
        return;
      }

      for(int next : graph[node]){
        al.add(next);
        path(graph,next,ans,al);
        al.remove(al.size()-1);
      }
    }
}