class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh =0;
        int minutes  =0;


        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while(!q.isEmpty() && fresh>0){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] current = q.poll();

                int row = current[0];
                int col = current[1];

                for(int [] direction : directions){

                    int newRow =direction[0]+row;
                    int newCol =direction[1]+col;

                    if(newRow>=0 && newRow<m && newCol >= 0 && newCol<n && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        fresh--;
                        q.offer(new int[]{newRow,newCol});
                    }


                } 
            }
            minutes++;
        }

        return fresh ==0 ? minutes : -1;

    }
}