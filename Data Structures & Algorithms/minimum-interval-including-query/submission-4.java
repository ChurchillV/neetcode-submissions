class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int SIZE = queries.length;
        int[][] queriesWithIndices = new int[SIZE][2];

        for(int i = 0; i < SIZE; i++) {
            queriesWithIndices[i] = new int[] {queries[i], i};
        }

        Arrays.sort(queriesWithIndices, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> {
            int cmp1 = Integer.compare(a[0], b[0]);

            if(cmp1 != 0) {
                return cmp1;
            }

            return Integer.compare(a[1], b[1]);
        });

        int[] result = new int[SIZE];
        int i = 0;

        for(int[] query : queriesWithIndices) {
            while(i < intervals.length && intervals[i][0] <= query[0]) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                heap.offer(new int[]{ end - start + 1, end });
                i++;
            }

            while(!heap.isEmpty() && heap.peek()[1] < query[0]) {
                heap.poll();
            }

            result[query[1]] = heap.isEmpty() ? -1 : heap.peek()[0];
        }

        return result;

    }
}
