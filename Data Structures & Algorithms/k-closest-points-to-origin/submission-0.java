class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((arr1, arr2) -> Double.compare(arr1[1], arr2[1]));

        for(int i = 0; i < points.length; i++) {
            double dx = Math.pow((points[i][0] - 0), 2);
            double dy = Math.pow((points[i][1] - 0), 2);
            double distance = Math.sqrt(dx + dy);

            queue.offer(new double[] { i, distance });
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++) {
            double[] pointRank = queue.poll();
            int index = (int) pointRank[0];
            result[i]= points[index];
        }

        return result;

    }
}
