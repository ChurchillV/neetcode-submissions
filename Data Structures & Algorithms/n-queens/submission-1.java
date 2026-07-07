class Solution {
    List<List<String>> result = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        Map<Integer, Set<Integer>> board = new TreeMap();
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= n; col++) {
                board.computeIfAbsent(row, c -> new HashSet<>()).add(col);
            }
        }

        for(int col = 1; col <= n; col++) {
            List<String> lines = new ArrayList();
            insert(1, col, n, lines, board);
        }

        return result;
    }

    public void insert(int row, int col, int max, List<String> lines, Map<Integer, Set<Integer>> board) {
        StringBuilder str = new StringBuilder();
        for(int c = 1; c <= max; c++) {
            if(c == col) {
                str.append("Q");
            } else {
                str.append(".");
            }
        }

        // System.out.println("Inserted: " + str.toString() + " at row: " + row + " col: " + col);

        lines.add(str.toString());
        if(lines.size() == max) {
            result.add(lines);
            return;
        }

        // System.out.println("Current board: " + board);
        Map<Integer, Set<Integer>> newBoard = findAvailableSlots(row, col, max, new TreeMap(board));
        // System.out.println("New board: " + newBoard);

        if(newBoard.get(row+1).isEmpty()) {
            // System.out.println("No more available slots. Returning");
            return;
        }

        Set<Integer> nextRow = newBoard.get(row+1);

        for(int availableCol : nextRow) {
            insert(row + 1, availableCol, max, new ArrayList(lines), newBoard);
        }
    }

    public Map<Integer, Set<Integer>> findAvailableSlots(int row, int col, int max, Map<Integer, Set<Integer>> board) {
        Map<Integer, Set<Integer>> newBoard = new TreeMap(board);

        for(Map.Entry<Integer, Set<Integer>> line : board.entrySet()) {
            newBoard.put(line.getKey(), new HashSet<>(line.getValue()));
        }

        int space = 1;
        for(int i = row+1; i <= max; i++) {
            Set<Integer> currRow = newBoard.get(i);
            currRow.remove(col);
            currRow.remove(col + space);
            currRow.remove(col - space);
            space++;
        }
        return newBoard;
    }
}
