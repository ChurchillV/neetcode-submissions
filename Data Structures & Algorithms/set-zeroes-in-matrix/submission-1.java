class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        List<int[]> zeroCoords = new ArrayList();

        for(int x = 0; x < ROWS; x++) {
            for(int y = 0; y < COLS; y++) {
                if(matrix[x][y] == 0) {
                    zeroCoords.add(new int[] {x, y});
                }
            }
        }

        for(int[] coords : zeroCoords) {
            int x = 0;
            int y = coords[1];

            while(x < ROWS) {
                matrix[x][y] = 0;
                x++;
            }

            x = coords[0];
            y = 0;
            while(y < COLS) {
                matrix[x][y] = 0;
                y++;
            }
        }
    }
}
