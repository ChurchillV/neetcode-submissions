class Solution {
        public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> squareMap = new HashMap<>();

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {

                String squareKey = (row / 3) + ", " + (col / 3);

                if(board[row][col] != '.') {
                    if(
                        rowMap.computeIfAbsent(row, r -> new HashSet<>()).contains(board[row][col]) ||
                        colMap.computeIfAbsent(col, c -> new HashSet<>()).contains(board[row][col]) ||
                        squareMap.computeIfAbsent(squareKey, s -> new HashSet<>()).contains(board[row][col])
                    ) {
                        return false;
                    } else {
                        rowMap.get(row).add(board[row][col]);
                        colMap.get(col).add(board[row][col]);
                        squareMap.get(squareKey).add(board[row][col]);
                    }
                }
            }
        }

        return true;
    }
}
