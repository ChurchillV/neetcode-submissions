class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        Queue<int[]> edgeCells = new LinkedList();
        boolean[][] unsurrounded = new boolean[ROWS][COLS];
        int[][] dirs = new int[][]{ {1,0},{-1,0},{0,1},{0,-1} };

        // 1st Row
        for(int c = 0; c < COLS; c++) {
            if(board[0][c] == 'O') {
                edgeCells.offer(new int[]{0, c});
            }
        }

        // Last Row
        for(int c = 0; c < COLS; c++) {
            if(board[ROWS-1][c] == 'O') {
                edgeCells.offer(new int[]{ROWS-1, c});
            }
        }

         // 1st col
        for(int r = 1; r < ROWS-1; r++) {
            if(board[r][0] == 'O') {
                edgeCells.offer(new int[]{r, 0});
            }
        }

         // Last Col
        for(int r = 1; r < ROWS-1; r++) {
            if(board[r][COLS-1] == 'O') {
                edgeCells.offer(new int[]{r, COLS-1});
            }
        }


        while(!edgeCells.isEmpty()) {
            int[] coords = edgeCells.poll();

            for(int[] dir : dirs) {
                int row = coords[0] + dir[0];
                int col = coords[1] + dir[1];

                if(
                    (row <= 0 || row >= ROWS-1) ||
                    (col <= 0 || col >= COLS-1) ||
                    (board[row][col] == 'X')    ||
                    unsurrounded[row][col]
                ) {
                    continue;
                }

                unsurrounded[row][col] = true;
                edgeCells.offer(new int[]{row, col});
            }
        }

        for(int row = 1; row < ROWS-1; row++) {
            for(int col = 1; col < COLS-1; col++) {
                if(board[row][col] == 'O' && !unsurrounded[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }
    }
}
