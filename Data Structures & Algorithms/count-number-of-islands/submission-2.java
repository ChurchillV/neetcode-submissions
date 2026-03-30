class Solution {

    public boolean isValidLand(char[][] grid, boolean[][] visited, int row, int col) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length)
                && grid[row][col] == '1' && (!visited[row][col]);
    }

    public void dfsAlt(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        int[] rowDirections = { 1, -1, 0, 0};
        int[] colDirections = { 0, 0, -1, 1};
        
        for(int direction = 0; direction < 4; direction++) {
            int newRow = rowDirections[direction] + row;
            int newCol = colDirections[direction] + col;

            if(isValidLand(grid, visited, newRow, newCol)) {
                dfsAlt(grid, visited, newRow, newCol);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int ROWS  = grid.length;
        int COLS  = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(grid[row][col] != '0' && !visited[row][col]) {
                    dfsAlt(grid, visited, row, col);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
}
