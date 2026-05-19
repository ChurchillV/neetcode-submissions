class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        int startRow = 0, startCol = 0, startIndex = 0;
        List<String> result = new ArrayList<>();

        for(String word : words) {
            boolean found = false;
            boolean[][] visited = new boolean[rows][cols];

            outer:
            for(int r = 0; r < rows; r++) {
                for(int c = 0; c < cols; c++) {
                    if(dfs(word, startIndex, r, c, board, visited)) {
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

    public boolean dfs(String word, int index, int row, int col, char[][] board, boolean[][] visited) {
        if(index == word.length()) {
            // System.out.println("Early exit. Reached end of word");
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (visited[row][col]) return false;
        if (word.charAt(index) != board[row][col]) return false;

        visited[row][col] = true;


        boolean result = dfs(word, index+1, row-1, col, board, visited) || // Up
                         dfs(word, index+1, row, col-1, board, visited)  || // Left
                         dfs(word, index+1, row, col+1, board, visited)  || // Right
                         dfs(word, index+1, row+1, col, board, visited);    // Down

        visited[row][col] = false;
        // System.out.println("Completed recursive call for " + word.charAt(index) + " in word: " + word);
        return result;
    }
}
