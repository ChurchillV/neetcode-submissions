class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                boolean[][] visited = new boolean[ROWS][COLS];
                boolean exists = recurse(row, col, 0, word, board, visited);

                if(exists) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean recurse(int row, int col, int idx, String word, char[][]board, boolean[][] visited) {
        if((row > board.length - 1 || row < 0) || (col > board[0].length - 1 || col < 0) || visited[row][col]) {
            return false;
        }

        if(idx == word.length() - 1 && board[row][col] == word.charAt(idx)) {
            return true;
        }

        if(word.charAt(idx) == board[row][col]) {
            visited[row][col] = true;

            boolean exists = recurse(row - 1, col, idx + 1, word, board, visited) || // up
                            recurse(row + 1, col, idx + 1, word, board, visited) || // down
                            recurse(row, col - 1, idx + 1, word, board, visited) || // left
                            recurse(row, col + 1, idx + 1, word, board, visited); // right
            
            if(!exists) {
                visited[row][col] = false;
            }

            return exists;   
        }

        return false;
    }
}
