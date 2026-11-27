class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Move from [00] -> [01] -> [0n], then [0+1 n] -> [0+m m]
        // m - no. of rows, n - no. of cols (3x3)
        // order: r1, c2, r2, c1, r2
        // At each boundary we hit, we change direction and reduce allowed space by 1
        // Stop when list size == mxn
        /**
        * row bound, col bound, [x][y], dir (1 [hor], 0[vert])
        * while(size != mxn)
        *   if(dir == 1) // we change y
        *       
        *
        *
        *
        */
        int matrixSize = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList();
        int x = 0, y = 0;
        int rowUpperBound = matrix.length;
        int colUpperBound = matrix[0].length;
        int rowLowerBound = -1;
        int colLowerBound = -1;
        int dir = 1; // 1 - left, -1 - right, 2 - down, -2 - up

        while(result.size() != matrixSize) {
            // l->r first
            if(dir == 1) {
                while(y <= colUpperBound-1) {
                    result.add(matrix[x][y]);
                    y++;
                }
                System.out.println("After moving right");
                System.out.println(result);
                dir = 2;
                y-=1;
                x++;
                rowLowerBound++;
            }
            // then u->down
            else if(dir == 2) {
                while(x <= rowUpperBound-1) {
                    result.add(matrix[x][y]);
                    x++; 
                }
                System.out.println("After moving down");
                System.out.println(result);
                dir = -1;
                x-=1;
                y--;
                colUpperBound--;
            }
            // then r -> l
            else if(dir == -1) {
                while(y > colLowerBound) {
                    result.add(matrix[x][y]);
                    y--;
                }
                System.out.println("After moving left");
                System.out.println(result);
                dir = -2;
                y+=1;
                x--;
                rowUpperBound--;
            }
            // then d -> u
            else if(dir == -2) {
                while(x > rowLowerBound) {
                    result.add(matrix[x][y]);
                    x--;
                }
                System.out.println("After moving up");
                System.out.println(result);
                dir = 1;
                y+=1;
                x++;
                colLowerBound++;
            }
        }

        return result;
    }
}
