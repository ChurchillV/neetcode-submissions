class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> rowSet = new HashMap<>();
        Map<Integer, HashSet<Character>> colSet = new HashMap<>();
        Map<String, HashSet<Character>> boxSet = new HashMap<>(); // (row // 3, col // 3)

        int rows = board.length;
        int cols = board[0].length;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                Character value = board[row][col];

                String squareKey = (row/3) + "," + (col/3);

                if(value == '.') {
                    continue;
                }

                if(
                    rowSet.computeIfAbsent(row, k -> new HashSet<>()).contains(value) ||
                    colSet.computeIfAbsent(col, k -> new HashSet<>()).contains(value) ||
                    boxSet.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(value)
                ) {
                    return false;
                }

                rowSet.get(row).add(value);
                colSet.get(col).add(value);
                boxSet.get(squareKey).add(value);
            }
        }

        return true;
    }
}
