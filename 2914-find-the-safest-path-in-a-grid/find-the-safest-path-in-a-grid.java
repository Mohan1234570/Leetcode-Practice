class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int[][] dist = new int[n][n];

        Queue<int[]> queue = new LinkedList<>();


        // Step 1: Multi-source BFS from all thieves
        for(int i = 0; i < n; i++) {

            Arrays.fill(dist[i], -1);

            for(int j = 0; j < n; j++) {

                if(grid.get(i).get(j) == 1) {

                    queue.offer(new int[]{i,j});

                    dist[i][j] = 0;
                }
            }
        }


        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };


        while(!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];


            for(int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];


                if(nr >= 0 && nc >= 0 &&
                   nr < n && nc < n &&
                   dist[nr][nc] == -1) {


                    dist[nr][nc] = dist[r][c] + 1;

                    queue.offer(new int[]{nr,nc});
                }
            }
        }



        // Step 2: Binary Search answer

        int low = 0;
        int high = n*n;

        int ans = 0;


        while(low <= high) {


            int mid = low + (high-low)/2;


            if(canReach(mid, dist)) {

                ans = mid;

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }


        return ans;
    }



    // BFS check
    private boolean canReach(int safe,
                             int[][] dist) {


        int n = dist.length;


        if(dist[0][0] < safe)
            return false;


        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][n];


        q.offer(new int[]{0,0});

        visited[0][0] = true;


        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };


        while(!q.isEmpty()) {


            int[] curr = q.poll();


            int r = curr[0];
            int c = curr[1];


            if(r == n-1 && c == n-1)
                return true;



            for(int[] dir : directions) {


                int nr = r + dir[0];
                int nc = c + dir[1];


                if(nr >= 0 && nc >= 0 &&
                   nr < n && nc < n &&
                   !visited[nr][nc] &&
                   dist[nr][nc] >= safe) {


                    visited[nr][nc] = true;

                    q.offer(new int[]{nr,nc});
                }
            }
        }


        return false;
    }
}