class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean [] vis = new boolean[n];

        int provinces =0;

        for(int city = 0; city<n; city++){
            if(!vis[city]){
                provinces++;

                dfs(isConnected,vis,city);
            }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected, boolean[] vis, int city){

        vis[city] = true;

        for(int neighber =0; neighber<isConnected.length; neighber++){

            if(isConnected[city][neighber] ==1 &&!vis[neighber]){
                dfs(isConnected,vis,neighber);
            }
        }

    }

}