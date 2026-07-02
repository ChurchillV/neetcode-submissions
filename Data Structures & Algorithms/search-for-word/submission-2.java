class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                boolean[][] visited = new boolean[rows][cols];
                boolean exists = recurse(r, c, board, visited, 0, word);

                if(exists) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean recurse(int row, int col, char[][] board, boolean[][] visited, int idx, String word) {

        if((row > board.length-1 || row < 0) || (col > board[0].length-1 || col < 0) || visited[row][col]) {
            return false;
        }

        if((board[row][col] == word.charAt(idx)) && idx == word.length() - 1) {
            return true;
        }

        if(board[row][col] == word.charAt(idx)) {
            visited[row][col] = true;

            boolean found = recurse(row-1, col, board, visited, idx+1, word) || // up
                            recurse(row+1, col, board, visited, idx+1, word) || // down
                            recurse(row, col-1, board, visited, idx+1, word) || // left
                            recurse(row, col+1, board, visited, idx+1, word);   // right
            
            if(!found) {
                visited[row][col] = false;
            }

            return found;
        }

        return false;
    }
}
