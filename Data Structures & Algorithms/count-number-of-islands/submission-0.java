class Solution {
    
   public boolean isSafe(char[][] grid, boolean[][] visited, int row, int col) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[row].length) && grid[row][col] == '1' && !visited[row][col];
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col) {

        visited[row][col] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for(int dir = 0; dir < 4; dir++) {
            int nr = dr[dir] + row;
            int nc = dc[dir] + col;

            if(isSafe(grid, visited, nr, nc)) {
                dfs(grid, visited, nr, nc);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean [][] visited = new boolean[rows][cols];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++){
                if(grid[r][c] != '0' && !visited[r][c]) {
                    dfs(grid, visited, r, c);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
}
