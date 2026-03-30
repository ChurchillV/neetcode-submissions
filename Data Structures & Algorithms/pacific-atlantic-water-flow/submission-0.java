class Solution {
    public void dfs(int row, int col, boolean[][] ocean, int[][] heights) {
        ocean[row][col] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        for(int[] dir : directions) {
            int nr = row + dir[0], nc = col + dir[1];

            // Check bounds
            if(nr >= 0 && nr < heights.length && nc >= 0 && 
                nc < heights[0].length && !ocean[nr][nc] && 
                heights[nr][nc] >= heights[row][col]) {
                    dfs(nr, nc, ocean, heights);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length,  COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS], atlantic = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++) {
            // Pacific -> row 1*  
            dfs(r, 0, pacific, heights);

            // Atlantic -> last row 
            dfs(r, COLS-1, atlantic, heights);
        }


        for(int c = 0; c < COLS; c++) {

            // Pacific -> col1
            dfs(0, c, pacific, heights);

            // Atlantic -> last col
            dfs(ROWS-1, c, atlantic, heights);
        }

        List<List<Integer>> results = new ArrayList<>();

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(atlantic[r][c] && pacific[r][c]) {
                    results.add(Arrays.asList(r, c));
                }
            }
        }

        return results;

    }
}
