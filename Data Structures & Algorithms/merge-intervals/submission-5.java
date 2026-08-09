class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));

        for(int[] interval : intervals) {
            queue.offer(interval);
        }

        List<int[]> result = new ArrayList();
        int SIZE = intervals.length;
        int[] prev = queue.poll();

        for(int i = 1; i < SIZE; i++) {
            int[] interval = queue.poll();

            if(interval[0] > prev[1]) {
                result.add(prev);
                prev = interval;
            }

            else {
                prev[0] = Math.min(interval[0], prev[0]);
                prev[1] = Math.max(interval[1], prev[1]);
            }
        }

        result.add(prev);
        return result.stream()
                    .toArray(int[][]::new);
    }
}
