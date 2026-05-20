class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        int rows = board.length;
        int cols = board[0].length;

        for(String word : words) {
            boolean found = false;
            boolean[][] visited = new boolean[rows][cols];

            outer:
            for(int r = 0; r < rows; r++) {
                for(int c = 0; c < cols; c++) {
                    if(dfs(word, r, c, 0, visited, board)) {
                        found = true;
                        break outer;
                    }
                }
            }
            
            if(found) {
                result.add(word);
            }
        }

        return result;
    }

    public boolean dfs(String word, int row, int col, int index, boolean[][] visited, char[][] board) {
        if(index == word.length()) {
            return true;
        }

        // Check if out of bounds
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        // Check if visited 
        if (visited[row][col]) {
            return false;
        }

        // Check if it's the wrong char
        if(!(word.charAt(index) == board[row][col])) {
            return false;
        }

        visited[row][col] = true;

        boolean result = dfs(word, row-1, col, index+1, visited, board) ||// Up
                         dfs(word, row+1, col, index+1, visited, board) ||// Down   
                         dfs(word, row, col-1, index+1, visited, board) ||// Left   
                         dfs(word, row, col+1, index+1, visited, board);// Right  

        visited[row][col] = false; 

        return result;
    }
}
