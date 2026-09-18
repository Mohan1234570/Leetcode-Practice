class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;


        Queue<int[]> q = new LinkedList<>();


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for(int[] direction : directions){
                int newRow = row+direction[0];
                int newCol = col+direction[1];

                if(newRow<0 || newRow>=m || newCol<0 || newCol>=n){
                  continue;
                }

                if(mat[newRow][newCol] != -1){
                    continue;
                }

                 mat[newRow][newCol] = mat[row][col]+1;
                q.offer(new int[]{newRow, newCol});

            }
        }

        return mat;
    }
}