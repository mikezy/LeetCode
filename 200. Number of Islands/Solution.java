class Solution {
        //dx dy for visiting neighbors
        int[] dx = {0, 1, 0 ,-1};
        int[] dy = {1, 0, -1, 0};
    public int numIslands(char[][] grid) {

        
        //corner case
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;  
        int res = 0; //init 0 island
        int m = grid.length;
        int n = grid[0].length;
        //traverse the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
        
    }
    
    private void dfs(char[][] grid, int i, int j) {

        //when will dfs return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        //mark island as water
        grid[i][j] = '0';
        //dfs the neighbor
        for (int move = 0; move < 4; move++) {
            dfs(grid, i+dx[move], j+dy[move]);
        }
        
    }
}

//traverse the entire grid
//mark all connected island as water
//return if no connected island is found